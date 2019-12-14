import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class JsRequestMessage {
    public String packId;
    public String jsScript;
    public String functionName;
    public ArrayList<DataTest> tests;
    //private DataTest[] tests;
    @JsonCreator
    public JsRequestMessage(@JsonProperty("packageId") String packId, @JsonProperty("jsScript") String jsScript,
                            @JsonProperty("functionName") String functionName, @JsonProperty("tests") ArrayList<DataTest> tests){
        this.functionName = functionName;
        this.jsScript = jsScript;
        this.packId = packId;
        this.tests = tests;
    }

    JsRequestMessage(ClassForTest test){
        this.functionName = test.functionName;
        this.jsScript = test.jsScript;
        this.packId = test.packageId;
        this.tests = new ArrayList<>(); this.tests.add(test.tests);
    }

    public ArrayList<DataTest> getTests(){
        return tests;
    }
    public String getPackId(){
        return packId;
    }
    public String getJsScript(){
        return jsScript;
    }
    public String getFunctionName(){
        return functionName;
    }

}
