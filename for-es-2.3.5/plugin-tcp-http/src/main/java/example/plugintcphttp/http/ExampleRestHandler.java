package example.plugintcphttp.http;

import example.plugintcphttp.common.ExampleCommonService;
import example.plugintcphttp.common.ExampleResponse;
import lombok.val;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.rest.BaseRestHandler;
import org.elasticsearch.rest.BytesRestResponse;
import org.elasticsearch.rest.RestChannel;
import org.elasticsearch.rest.RestController;
import org.elasticsearch.rest.RestRequest;

import static org.elasticsearch.rest.RestRequest.Method.GET;
import static org.elasticsearch.rest.RestStatus.OK;

public class ExampleRestHandler extends BaseRestHandler {

    private ExampleCommonService service;

    @Inject
    public ExampleRestHandler(Settings settings, RestController controller, Client client, ExampleCommonService service) {
        super(settings, controller, client);
        this.service = service;
        controller.registerHandler(GET, "/_greetings", this);
    }

    @Override
    protected void handleRequest(RestRequest restRequest, RestChannel channel, Client client) throws Exception {
        val builder = channel.newBuilder();
        val response = new ExampleResponse(service.getGreetings());
        response.toXContent(builder, restRequest);
        channel.sendResponse(new BytesRestResponse(OK, builder));
    }
}
