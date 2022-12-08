package com.example.dbcoursework.repository;

import com.example.dbcoursework.entity.SysAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SysAuthRepository extends JpaRepository<SysAuth, Long> {
    Optional<SysAuth> findFirstByUsername(String username);
}
