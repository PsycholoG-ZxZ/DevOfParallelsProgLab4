import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class JsRequestMessage {
    public String packId;
    public String jsScript;
    public String functionName;
    public ArrayList<DataTest> tests;
    @JsonCreator
    public JsRequestMessage(@JsonProperty("packageId") String packId, @JsonProperty("jsScript") String jsScript,
                            @JsonProperty("functionName") String functionName, @JsonProperty("tests") Object[] tests){
        this.functionName = functionName;
        this.jsScript = jsScript;
        this.packId = packId;
        this.tests = tests;
    }
}
