package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.Person;
import com.example.dbcoursework.entity.local.BasicEntity;
import com.example.dbcoursework.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Boolean checkPersonByName(String name, Long id) {
        Person person = personRepository.findFirstByNameAndId(name, id).orElse(null);
        return person != null;
    }

    public Optional<Long> registerPerson(BasicEntity basicPerson, List<BasicEntity> orgs, List<BasicEntity> roles) {
        Person person = new Person();
        person.setEnterData(LocalDateTime.now());
        person.setIsDeleted(false);
        person.setName(basicPerson.getName());
        person = personRepository.save(person);
        for (BasicEntity org : orgs) {
            try {
                personRepository.insertLinkOrg(org.getId(), person.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (BasicEntity role : roles) {
            try {
                personRepository.insertLinkRole(role.getId(), person.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.of(person.getId());
    }
}
