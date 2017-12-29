package example.plugintcphttp.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;

@Getter
@ToString
@AllArgsConstructor
public class ExampleResponse extends ActionResponse implements ToXContent {

    private String greetings;

    @Override
    public XContentBuilder toXContent(XContentBuilder xContentBuilder, Params params) throws IOException {
        xContentBuilder.startObject()
                .field("greetings", greetings)
                .endObject();
        return xContentBuilder;
    }

    @Override
    public void readFrom(StreamInput in) throws IOException {
        super.readFrom(in);
        greetings = in.readString();
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        super.writeTo(out);
        out.writeString(greetings);
    }
}
