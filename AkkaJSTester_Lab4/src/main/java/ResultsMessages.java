import java.util.ArrayList;

public class ResultsMessages {
    private String packageId;
    private ArrayList<DataTest> value;

    public ResultsMessages(String packId, ArrayList<DataTest> val){
        this.packageId = packId;
        this.value = val;
    }

    public ArrayList<DataTest> getValue(){
        return value;
    }

    public String getPackageId(){
        return packageId;
    }
}
