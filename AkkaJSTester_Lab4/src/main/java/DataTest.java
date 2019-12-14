import akka.actor.FSM;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataTest {
    private String testName;
    private String exResult;
    public Object[] params;

    Boolean status;

    DataTest(@JsonProperty("testName") String testName, @JsonProperty("expectedResult") String exResult,
             @JsonProperty("params") Object[] params, @JsonProperty("status") Boolean status){
        this.exResult = exResult;
        this.params = params;
        this.testName = testName;
        this.status = null;
    }

    @JsonProperty("expectedResult")
    public String getExResult(){
            return exResult;
    }
}
