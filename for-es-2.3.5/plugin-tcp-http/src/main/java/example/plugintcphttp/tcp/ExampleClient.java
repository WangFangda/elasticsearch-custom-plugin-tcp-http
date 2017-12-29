package example.plugintcphttp.tcp;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.elasticsearch.client.ElasticsearchClient;

@AllArgsConstructor
public class ExampleClient {

    @NonNull
    private ElasticsearchClient elasticsearchClient;

    public ExampleRequestBuilder prepare() {
        return new ExampleRequestBuilder(elasticsearchClient, ExampleAction.INSTANCE);
    }

}
