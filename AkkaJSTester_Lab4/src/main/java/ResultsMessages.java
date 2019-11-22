public class ResultsMessages {
    private String value, packageId;

    public ResultsMessages(String packId, String val){
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
