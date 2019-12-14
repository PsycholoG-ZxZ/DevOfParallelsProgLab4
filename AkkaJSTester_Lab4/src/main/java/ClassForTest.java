import com.sun.org.apache.xpath.internal.operations.Bool;

public class ClassForTest {
    public String packageId;
    public String functionName, jsScript;
    //public Object[] tests;
    public DataTest tests;
    public ClassForTest(String packageId, String functionName, String jsScript, DataTest tests){
        this.functionName = functionName;
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.tests = tests;
    }

    public String getPackageId() {
        return packageId;
    }
    public String getFunctionName() {
        return functionName;
    }
    public String getJsScript() {
        return jsScript;
    }
    public DataTest getTests() {
        return tests;
    }
    void setStatus(Boolean stat){
        this.tests.status = stat;
    }
}
