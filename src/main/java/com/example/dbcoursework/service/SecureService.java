package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.SysAuth;
import com.example.dbcoursework.entity.local.SecureEntity;
import com.example.dbcoursework.repository.SysAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SecureService {

    private final SysAuthRepository sysAuthRepository;

    public Boolean checkAuthorization(SecureEntity secureEntity) {
        SysAuth sysAuth = sysAuthRepository.findFirstByUsername(secureEntity.getLogin()).orElse(null);
        return sysAuth != null && Objects.equals(sysAuth.getPassword(), secureEntity.getPassword());
    }
}
