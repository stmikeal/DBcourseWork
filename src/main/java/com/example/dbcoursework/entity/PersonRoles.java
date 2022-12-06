package com.example.dbcoursework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonRoles {
    @Id
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;
}
