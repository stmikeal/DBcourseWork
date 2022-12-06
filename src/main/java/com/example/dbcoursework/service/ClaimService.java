package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.Claim;
import com.example.dbcoursework.entity.local.ClaimEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClaimService {
    // Создает claim
    public Boolean createClaim(ClaimEntity claimEntity) {
        return false;
    }

    // Создает ответ на claim
    public Boolean createAnswerClaim(ClaimEntity claimEntity, Long responseId) {
        return false;
    }

    // Получение последнего ответа для участника
    public Optional<Claim> getLastAnswer(String login) {
        return Optional.empty();
    }

    // Получение ответа по id
    public  Optional<Claim> getAnswerById(String login, Long id) {
        return Optional.empty();
    }
}
