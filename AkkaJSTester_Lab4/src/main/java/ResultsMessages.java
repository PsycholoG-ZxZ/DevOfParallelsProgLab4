import java.util.ArrayList;

public class ResultsMessages {
    private String packageId;
    private ArrayList<DataTest> value;
    private Boolean res;
    public ResultsMessages(String packId, ArrayList<DataTest> val, Boolean stat){
        this.packageId = packId;
        this.value = val;
        this.res = stat;
    }

    public ArrayList<DataTest> getValue(){
        return value;
    }

    public String getPackageId(){
        return packageId;
    }

    public Boolean getRes(){
        return res;
    }
}
