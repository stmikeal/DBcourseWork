package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.local.DescriptionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService {

    public Boolean registerOrganization(DescriptionEntity descriptionEntity){
        return false; //TODO добавление организации (вернуть False если оргганизация с таким именем уже существует)
    }

}
