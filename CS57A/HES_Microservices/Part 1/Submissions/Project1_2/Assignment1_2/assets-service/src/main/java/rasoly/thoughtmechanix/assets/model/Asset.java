package rasoly.thoughtmechanix.assets.model;

public class Asset {
    private String id;
    private String organizationId;
    private String productName;
    private String assetType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public Asset withId(String id){
        this.setId( id );
        return this;
    }

    public Asset withOrganizationId(String organizationId){
        this.setOrganizationId(organizationId);
        return this;
    }

    public Asset withProductName(String productName){
        this.setProductName(productName);
        return this;
    }

    public Asset withAssetType(String assetType){
        this.setAssetType(assetType);
        return this;
    }


}
