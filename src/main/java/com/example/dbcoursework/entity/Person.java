package com.example.dbcoursework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id()
    Long id;

    @Column(name = "enter_data")
    LocalDateTime enterData;

    @Column(name = "is_deleted")
    Boolean isDeleted;

    @Column(name = "name")
    String name;
}
