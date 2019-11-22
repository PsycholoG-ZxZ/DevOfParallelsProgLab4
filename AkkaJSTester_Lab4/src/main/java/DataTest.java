import akka.actor.FSM;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataTest {
    private String testName;
    private String exResult;
    public Object[] params;

    DataTest(@JsonProperty("testName") String testName, @JsonProperty("expectedResult") String exResult, @JsonProperty("params") String params){
        
    }
}
