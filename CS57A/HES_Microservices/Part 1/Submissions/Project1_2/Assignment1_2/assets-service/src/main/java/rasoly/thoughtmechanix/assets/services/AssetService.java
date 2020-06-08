package rasoly.thoughtmechanix.assets.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rasoly.thoughtmechanix.assets.model.Asset;

import java.util.List;
import java.util.UUID;

@Service
public class AssetService {

    public Asset getAsset(String organizationId, String assetId){
        return new Asset()
                .withId(assetId)
                .withOrganizationId(UUID.randomUUID().toString())
                .withProductName("Test Asset Name")
                .withAssetType("Tangible");
    }

    public void getAssetsByOrganization(String organizationId){

    }

    public void saveAsset(Asset asset){

    }

    public void updateAsset(Asset asset){

    }

    public void deleteAsset(String assetId){

    }
}
