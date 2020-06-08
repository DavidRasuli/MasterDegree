package com.thoughtmechanix.organization.services;

import com.thoughtmechanix.organization.model.Organization;
import com.thoughtmechanix.organization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository orgRepository;

    public Organization getOrganization(String organizationId) {
        return orgRepository.findById(organizationId);
    }

    public void saveOrganization(Organization org){
        org.setId( UUID.randomUUID().toString());

        orgRepository.save(org);

    }

    public void updateOrganization(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrganization(Organization org){
        orgRepository.delete( org.getId());
    }
}
