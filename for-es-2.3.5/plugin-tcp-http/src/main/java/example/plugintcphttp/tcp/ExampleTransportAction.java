package example.plugintcphttp.tcp;

import example.plugintcphttp.common.ExampleCommonService;
import example.plugintcphttp.common.ExampleResponse;
import lombok.val;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.support.ActionFilters;
import org.elasticsearch.action.support.HandledTransportAction;
import org.elasticsearch.cluster.metadata.IndexNameExpressionResolver;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.threadpool.ThreadPool;
import org.elasticsearch.transport.TransportService;

public class ExampleTransportAction extends HandledTransportAction<ExampleRequest, ExampleResponse> {

    private ExampleCommonService service;

    @Inject
    public ExampleTransportAction(Settings settings,
                                  ThreadPool threadPool,
                                  TransportService transportService,
                                  ActionFilters actionFilters,
                                  IndexNameExpressionResolver indexNameExpressionResolver,
                                  ExampleCommonService service) {

        super(settings,
                ExampleAction.NAME,
                threadPool,
                transportService,
                actionFilters,
                indexNameExpressionResolver,
                ExampleRequest.class);
        this.service = service;
    }

    @Override
    public void doExecute(final ExampleRequest request, final ActionListener<ExampleResponse> listener) {
        val response = new ExampleResponse(service.getGreetings());
        listener.onResponse(response);
    }

}
