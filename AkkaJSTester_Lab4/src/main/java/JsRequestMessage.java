import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsRequestMessage {
    public String packId;
    public String jsScript;
    public String functionName;
    public Object[] tests;
    @JsonCreator
    public JsRequestMessage(@JsonProperty("packId") String packId, @JsonProperty("jsScript") String jsScript,
                            @JsonProperty("functionName") String functionName, @JsonProperty("tests") Object[] tests){
        this.functionName = functionName;
        this.
    }
}
