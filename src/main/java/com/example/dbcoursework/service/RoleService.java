package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.local.DescriptionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    public Boolean registerRole(DescriptionEntity descriptionEntity){
        return false; //TODO добавление роли (вернуть False если роль с таким именем уже существует)
    }

}
