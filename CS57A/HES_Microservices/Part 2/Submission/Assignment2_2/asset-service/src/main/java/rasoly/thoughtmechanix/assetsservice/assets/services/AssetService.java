package rasoly.thoughtmechanix.assetsservice.assets.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import rasoly.thoughtmechanix.assetsservice.assets.clients.OrganizationRestTemplateClient;
import rasoly.thoughtmechanix.assetsservice.assets.config.ServiceConfig;
import rasoly.thoughtmechanix.assetsservice.assets.model.Asset;
import rasoly.thoughtmechanix.assetsservice.assets.model.Organization;
import rasoly.thoughtmechanix.assetsservice.assets.repository.AssetRepository;
import rasoly.thoughtmechanix.assetsservice.assets.utils.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class AssetService {
    private static final Logger logger = LoggerFactory.getLogger(AssetService.class);

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    ServiceConfig config;

    @Autowired
    OrganizationRestTemplateClient organizationRestClient;

    public Asset getAsset(String organizationId, String assetId){
        Asset asset = assetRepository.findByOrganizationIdAndAssetId(organizationId,assetId);
        Organization org = getOrganization(organizationId);
        return asset.withOrganizationId(org.getId());
    }

    //@HystrixCommand
    private Organization getOrganization(String organizationId) {
        return organizationRestClient.getOrganization(organizationId);
    }

    private void randomlyRunLong(){
        Random rand = new Random();

        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        if (randomNum==3) sleep();
    }

    private void sleep(){
        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @HystrixCommand(fallbackMethod = "buildFallbackAssetList",
            threadPoolKey = "assetByOrgThreadPool",
            threadPoolProperties =
                    {@HystrixProperty(name = "coreSize",value="30"),
                            @HystrixProperty(name="maxQueueSize", value="10")},
            commandProperties={
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold", value="10"),
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage", value="75"),
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds", value="7000"),
                    @HystrixProperty(name="metrics.rollingStats.timeInMilliseconds", value="15000"),
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "12000"),
                    @HystrixProperty(name="metrics.rollingStats.numBuckets", value="5")}
    )
    public List<Asset> getAssetByOrg(String organizationId){
        logger.debug("LicenseService.getLicensesByOrg  Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
        randomlyRunLong();
        return assetRepository.findByOrganizationId(organizationId);
    }

    private List<Asset> buildFallbackAssetList(String organizationId){
        List<Asset> fallbackList = new ArrayList<>();
        Asset license = new Asset()
                .withId("123456")
                .withOrganizationId( organizationId )
                .withProductName("Sorry no asset information currently available");

        fallbackList.add(license);
        return fallbackList;
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
