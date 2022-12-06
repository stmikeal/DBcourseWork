package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.local.SecureEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecureService {

    //TODO проверка валидности данных аутентификации
    public Boolean checkAuthorization(SecureEntity secureEntity) {
        return false;
    }
}
