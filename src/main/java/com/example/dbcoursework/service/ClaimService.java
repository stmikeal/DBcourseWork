package com.example.dbcoursework.service;

import com.example.dbcoursework.dict.ClaimStatusDict;
import com.example.dbcoursework.entity.Claim;
import com.example.dbcoursework.entity.SysAuth;
import com.example.dbcoursework.entity.local.ClaimEntity;
import com.example.dbcoursework.repository.ClaimRepository;
import com.example.dbcoursework.repository.SysAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClaimService {

    private final SysAuthRepository sysAuthRepository;
    private final ClaimRepository claimRepository;

    public Boolean createClaim(ClaimEntity claimEntity, String login) {
        SysAuth sysAuth = sysAuthRepository.findFirstByUsername(login).orElse(null);
        if (sysAuth == null) return false;
        Claim claim = new Claim();
        claim.setData(claimEntity.getData());
        claim.setMemberIn(sysAuth.getMember());
        claim.setMemberOut(claimEntity.getMemberOut());
        claim.setCreatedDate(LocalDateTime.now());
        claim.setType(claimEntity.getType());
        claim.setStatus(ClaimStatusDict.NEW.id);
        claimRepository.save(claim);
        return true;
    }

    public Boolean createAnswerClaim(ClaimEntity claimEntity, Long responseId) {
        Claim origin = claimRepository.findById(responseId).orElse(null);
        if (origin == null) return false;
        origin.setStatus(ClaimStatusDict.DONE.id);
        origin = claimRepository.save(origin);
        Claim response = new Claim();
        response.setData(claimEntity.getData());
        response.setMemberIn(origin.getMemberOut());
        response.setMemberOut(origin.getMemberIn());
        response.setCreatedDate(LocalDateTime.now());
        response.setType(origin.getType());
        response.setStatus(ClaimStatusDict.NEW.id);
        claimRepository.save(response);
        return false;
    }

    public Optional<Claim> getLastAnswer(String login) {
        SysAuth sysAuth = sysAuthRepository.findFirstByUsername(login).orElse(null);
        if (sysAuth == null) return Optional.empty();
        Claim response = claimRepository
                .findFirstByMemberOutAndStatus(sysAuth.getMember(), ClaimStatusDict.NEW.id).orElse(null);
        if (response == null) return Optional.empty();
        return Optional.of(response);
    }

    public  Optional<Claim> getAnswerById(String login, Long id) {
        SysAuth sysAuth = sysAuthRepository.findFirstByUsername(login).orElse(null);
        if (sysAuth == null) return Optional.empty();
        Claim response = claimRepository.findById(id).orElse(null);
        if (response == null || !Objects.equals(sysAuth.getMember(), response.getMemberOut()))
            return Optional.empty();
        return Optional.of(response);
    }
}
