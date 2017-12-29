package example.plugintcphttp.tcp;

import lombok.NoArgsConstructor;
import org.elasticsearch.action.ActionRequest;
import org.elasticsearch.action.ActionRequestValidationException;

@NoArgsConstructor
public class ExampleRequest extends ActionRequest<ExampleRequest> {

    @Override
    public ActionRequestValidationException validate() {
        return null;
    }
}
