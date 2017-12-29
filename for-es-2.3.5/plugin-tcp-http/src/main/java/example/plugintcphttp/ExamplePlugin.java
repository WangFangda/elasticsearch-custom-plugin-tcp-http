package example.plugintcphttp;

import example.plugintcphttp.http.ExampleRestHandler;
import example.plugintcphttp.tcp.ExampleAction;
import example.plugintcphttp.tcp.ExampleTransportAction;
import org.elasticsearch.action.ActionModule;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.rest.RestModule;

public class ExamplePlugin extends Plugin {

    @Override
    public String name() {
        return "Example Plugin";
    }

    @Override
    public String description() {
        return "Demo project for Custom Plugin with TCP and HTTP support";
    }

    public void onModule(RestModule restModule) {
        restModule.addRestAction(ExampleRestHandler.class);
    }

    public void onModule(ActionModule actionModule) {
        actionModule.registerAction(ExampleAction.INSTANCE, ExampleTransportAction.class);
    }
}
