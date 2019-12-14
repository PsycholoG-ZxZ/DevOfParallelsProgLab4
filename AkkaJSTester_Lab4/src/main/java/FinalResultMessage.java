public class FinalResultMessage {
    private String res;

    public FinalResultMessage(Boolean stat){
        res = stat.toString();
    }

    public String getRes() {
        return res;
    }
}
