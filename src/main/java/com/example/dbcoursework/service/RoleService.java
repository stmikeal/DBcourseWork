package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.Role;
import com.example.dbcoursework.entity.local.DescriptionEntity;
import com.example.dbcoursework.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Boolean registerRole(DescriptionEntity descriptionEntity){
        Role role = roleRepository.findFirstByName(descriptionEntity.getName()).orElse(null);
        if (role != null) return false;
        role = new Role();
        role.setName(descriptionEntity.getName());
        role.setDescription(descriptionEntity.getDescription());
        roleRepository.save(role);
        return true;
    }

}
