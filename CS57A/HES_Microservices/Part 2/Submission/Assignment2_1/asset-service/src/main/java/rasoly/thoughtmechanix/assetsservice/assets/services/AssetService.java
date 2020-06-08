package rasoly.thoughtmechanix.assetsservice.assets.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import rasoly.thoughtmechanix.assetsservice.assets.clients.OrganizationDiscoveryClient;
import rasoly.thoughtmechanix.assetsservice.assets.clients.OrganizationFeignClient;
import rasoly.thoughtmechanix.assetsservice.assets.clients.OrganizationRestTemplateClient;
import rasoly.thoughtmechanix.assetsservice.assets.config.ServiceConfig;
import rasoly.thoughtmechanix.assetsservice.assets.model.Organization;
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

    @Autowired
    OrganizationFeignClient organizationFeignClient;

    @Autowired
    OrganizationRestTemplateClient organizationRestClient;

    @Autowired
    OrganizationDiscoveryClient organizationDiscoveryClient;


    private Organization retrieveOrgInfo(String organizationId, String clientType){
        Organization organization = null;

        switch (clientType) {
            case "feign":
                System.out.println("I am using the feign client");
                organization = organizationFeignClient.getOrganization(organizationId);
                break;
            case "rest":
                System.out.println("I am using the rest client");
                organization = organizationRestClient.getOrganization(organizationId);
                break;
            case "discovery":
                System.out.println("I am using the discovery client");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
            default:
                organization = organizationRestClient.getOrganization(organizationId);
        }

        return organization;
    }

    public Asset getAsset(String organizationId, String assetId, String clientType){
        Asset asset = assetRepository.findByOrganizationIdAndAssetId(organizationId,assetId);
        Organization org = retrieveOrgInfo(organizationId, clientType);
        return asset.withOrganizationId(org.getId());
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
