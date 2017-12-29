package example.plugintcphttp.tcp;

import example.plugintcphttp.common.ExampleResponse;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.Action;
import org.elasticsearch.client.ElasticsearchClient;

public class ExampleAction extends Action<ExampleRequest, ExampleResponse, ExampleRequestBuilder> {

    public static final ExampleAction INSTANCE = new ExampleAction();
    public static final String NAME = "greetings:read";

    public ExampleAction() {
        super(NAME);
    }

    @Override
    public ExampleRequestBuilder newRequestBuilder(ElasticsearchClient client) {
        return new ExampleRequestBuilder(client, INSTANCE);
    }

    @Override
    public ExampleResponse newResponse() {
        return new ExampleResponse(StringUtils.EMPTY);
    }
}
