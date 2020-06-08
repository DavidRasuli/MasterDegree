package rasoly.thoughtmechanix.assetservice.assets.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rasoly.thoughtmechanix.assetservice.assets.model.Asset;

import java.util.List;

@Repository
public interface AssetRepository extends CrudRepository<Asset, String>{
    List<Asset> findByOrganizationId(String organizationId);
    Asset findByOrganizationIdAndAssetId(String organizationId, String assetId);
}
