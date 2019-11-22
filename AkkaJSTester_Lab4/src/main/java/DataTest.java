import akka.actor.FSM;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DataTest {
    private String testName;
    private String result;
    public Object[] values;

    DataTest(@JsonProperty("testName") String testName, @JsonProperty("expectedResult") String result, @JsonProperty(""))
}
