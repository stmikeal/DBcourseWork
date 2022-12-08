package com.example.dbcoursework.repository;

import com.example.dbcoursework.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findFirstByNameAndId(String name, Long id);

    @Query(nativeQuery = true, value = "insert into org_person_link (organization, person) values (:orgId, :perId)")
    void insertLinkOrg(Long orgId, Long perId);

    @Query(nativeQuery = true, value = "insert into role_person_link (person_role, person) values (:roleId, :perId)")
    void insertLinkRole(Long roleId, Long perId);
}
