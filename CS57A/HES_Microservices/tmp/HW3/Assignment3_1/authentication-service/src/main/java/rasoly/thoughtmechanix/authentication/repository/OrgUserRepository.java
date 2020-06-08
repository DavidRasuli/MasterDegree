package rasoly.thoughtmechanix.authentication.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rasoly.thoughtmechanix.authentication.model.UserOrganization;

@Repository
public interface OrgUserRepository extends CrudRepository<UserOrganization,String>  {
    public UserOrganization findByUserName(String userName);
}
