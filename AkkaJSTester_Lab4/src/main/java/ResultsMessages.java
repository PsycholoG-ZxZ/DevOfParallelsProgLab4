import java.util.ArrayList;

public class ResultsMessages {
    private String packageId;
    private ArrayList<String> value;

    public ResultsMessages(String packId, ArrayList<String> val){
        this.packageId = packId;
        this.value = val;
    }

    public ArrayList<String> getValue(){
        return value;
    }

    public String getPackageId(){
        return packageId;
    }
}
