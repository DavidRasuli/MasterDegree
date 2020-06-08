package rasoly.thoughtmechanix.assetservice.assets.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import rasoly.thoughtmechanix.assetservice.assets.config.ServiceConfig;
import rasoly.thoughtmechanix.assetservice.assets.model.Asset;
import rasoly.thoughtmechanix.assetservice.assets.services.AssetService;
import rasoly.thoughtmechanix.assetservice.assets.utils.UserContextHolder;

import java.util.List;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/assets")
public class AssetsServiceController {
    private static final Logger logger = LoggerFactory.getLogger(AssetsServiceController.class);


    @Autowired
    private AssetService assetService;

    @Autowired
    private ServiceConfig serviceConfig;


    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Asset> getAssets(@PathVariable("organizationId") String organizationId) {
        logger.debug("AssetsServiceController Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
        return assetService.getAssetByOrg(organizationId);
    }

    @RequestMapping(value="/{assetId}",method = RequestMethod.GET)
    public Asset getAssets(@PathVariable("organizationId") String organizationId,
                           @PathVariable("assetId") String assetId) {

        return assetService.getAsset(organizationId, assetId);
    }

    @RequestMapping(value="/",method = RequestMethod.PUT)
    public void updateAssets(@RequestBody Asset asset) {
         assetService.updateAsset(asset);
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public void saveAssets( @RequestBody Asset asset) {
        assetService.saveAsset(asset);
    }

    @RequestMapping(value="{assetId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAssets( @PathVariable("assetId") String assetId) {
        assetService.deleteAsset(assetId);
    }
}
