package com.example.dbcoursework.service;

import com.example.dbcoursework.entity.local.BasicEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    //TODO метод должен возвращать существует ли пользователь с данным именем и данным id
    public Boolean checkPersonByName(String name, Long id) {
        return false;
    }

    //TODO регистрирует пользователя с заданными связями, возвращает невалидный optional или id новой сущнсоти
    public Optional<Long> registerPerson(BasicEntity person, List<BasicEntity> org, List<BasicEntity> role) {
        return Optional.empty();
    }
}
