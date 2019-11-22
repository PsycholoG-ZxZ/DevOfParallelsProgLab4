public class ClassForTest {
    public String packageId;
    public String functionName, jsScript;
    public Object[] tests;

    public ClassForTest(String packageId, String functionName, String jsScript, Object[] tests){
        this.functionName = functionName;
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.tests = tests;
    }
}
