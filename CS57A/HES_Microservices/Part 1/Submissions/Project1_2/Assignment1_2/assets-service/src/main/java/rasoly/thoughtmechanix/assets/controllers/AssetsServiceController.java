package rasoly.thoughtmechanix.assets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import rasoly.thoughtmechanix.assets.model.Asset;
import rasoly.thoughtmechanix.assets.services.AssetService;

import java.util.List;

@RestController
@RequestMapping(value="v1/organizations/{organizationId}/assets")
public class AssetsServiceController {
    @Autowired
    private AssetService assetService;

    @RequestMapping(value="/{assetId}",method = RequestMethod.GET)
    public Asset getAssets(@PathVariable("organizationId") String organizationId,
                           @PathVariable("assetId") String assetId) {

        return new Asset()
                .withId(assetId)
                .withAssetType("Tangible")
                .withOrganizationId(organizationId)
                .withProductName("Some Asset Name");
    }

    @RequestMapping(value="/",method = RequestMethod.PUT)
    public String updateAssets(@RequestBody Asset asset) {
        return String.format("This is put");
    }

    @RequestMapping(value="/",method = RequestMethod.POST)
    public String saveAssets( @RequestBody Asset asset) {
        return String.format("This is post");
    }

    @RequestMapping(value="{assetId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAssets( @PathVariable("assetId") String assetId) {
        return String.format("This is delete");
    }
}
