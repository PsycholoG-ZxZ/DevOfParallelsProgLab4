import com.fasterxml.jackson.annotation.JsonCreator;

public class JsRequestMessage {
    public String packId;
    public String jsScript;
    public String functionName;
    public Object[] tests;
    @JsonCreator
    public Post
}
