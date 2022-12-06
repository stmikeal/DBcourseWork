package com.example.dbcoursework.repository;

import com.example.dbcoursework.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    @Override
    List<Claim> findAll();
}
