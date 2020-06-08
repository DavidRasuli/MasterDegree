package rasoly.thoughtmechanix.assetsservice.assets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import rasoly.thoughtmechanix.assetsservice.assets.model.Asset;
import rasoly.thoughtmechanix.assetsservice.assets.services.AssetService;

import java.util.List;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/assets")
public class AssetsServiceController {
    @Autowired
    private AssetService assetService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Asset> getAssets(@PathVariable("organizationId") String organizationId) {

        return assetService.getAssetsByOrganization(organizationId);
    }

    @RequestMapping(value="/{assetId}",method = RequestMethod.GET)
    public Asset getAssets(@PathVariable("organizationId") String organizationId,
                           @PathVariable("assetId") String assetId) {

        return assetService.getAsset(organizationId,assetId);
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
