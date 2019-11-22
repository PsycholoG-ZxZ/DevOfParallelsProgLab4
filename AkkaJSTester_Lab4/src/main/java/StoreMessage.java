public class StoreMessage {
    private String packageID, value;

    public StoreMessage(String packID, String value){
        this.packageID = packID;
        this.value = value;
    }

    public String getPackageID(){
        return packageID;
    }
    public String getValue(){
        return value;
    }
}
