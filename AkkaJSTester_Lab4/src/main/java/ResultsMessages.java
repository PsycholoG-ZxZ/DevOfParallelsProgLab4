import java.util.ArrayList;

public class ResultsMessages {
    private String value, packageId;

    public ResultsMessages(String packId, ArrayList<String> val){
        this.packageId = packId;
        this.value = val;
    }

    public String getValue(){
        return value;
    }

    public String getPackageId(){
        return packageId;
    }
}
