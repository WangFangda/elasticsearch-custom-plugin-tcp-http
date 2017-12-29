package example.plugintcphttp.tcp;

import example.plugintcphttp.common.ExampleResponse;
import org.elasticsearch.action.ActionRequestBuilder;
import org.elasticsearch.client.ElasticsearchClient;

public class ExampleRequestBuilder extends ActionRequestBuilder<ExampleRequest, ExampleResponse, ExampleRequestBuilder> {

    public ExampleRequestBuilder(ElasticsearchClient client, ExampleAction action) {
        super(client, action, new ExampleRequest());
    }
}