package rasoly.thoughtmechanix.assetsservice.assets.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import rasoly.thoughtmechanix.assetsservice.assets.config.ServiceConfig;
import rasoly.thoughtmechanix.assetsservice.assets.repository.AssetRepository;
import rasoly.thoughtmechanix.assetsservice.assets.model.Asset;

import java.util.List;
import java.util.UUID;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    ServiceConfig config;

    public Asset getAsset(String organizationId, String assetId){
        Asset asset = assetRepository.findByOrganizationIdAndAssetId(organizationId,assetId);
        return asset.withProductName(config.getExampleProperty());
    }

    public List<Asset> getAssetsByOrganization(String organizationId){
        return assetRepository.findByOrganizationId(organizationId);
    }

    public void saveAsset(Asset asset){
        asset.withId(UUID.randomUUID().toString());
        assetRepository.save(asset);
    }

    public void updateAsset(Asset asset){
        System.out.println("test - asset details : \n"+asset);
        assetRepository.save(asset);
    }

    public void deleteAsset(String assetId){
        assetRepository.delete(assetId);
    }
}
