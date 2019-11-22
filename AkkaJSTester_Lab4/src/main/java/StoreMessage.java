public class StoreMessage {
    private String packageId, value;

    public StoreMessage(String packID, String value){
        this.packageId = packID;
        this.value = value;
    }

    public String getPackageId(){
        return packageId;
    }
    public String getValue(){
        return value;
    }
}
