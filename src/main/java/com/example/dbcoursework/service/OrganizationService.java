package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.Organization;
import com.example.dbcoursework.entity.local.DescriptionEntity;
import com.example.dbcoursework.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;

    public Boolean registerOrganization(DescriptionEntity descriptionEntity){
        Organization org = organizationRepository.findFirstByName(descriptionEntity.getName()).orElse(null);
        if (org != null) return false;
        org = new Organization();
        org.setName(descriptionEntity.getName());
        org.setDescription(descriptionEntity.getDescription());
        organizationRepository.save(org);
        return true;
    }

}
