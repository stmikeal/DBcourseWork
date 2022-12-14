package com.example.dbcoursework.repository;

import com.example.dbcoursework.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    Optional<Claim> findFirstByMemberOutAndStatus(Long member, Long status);
}
