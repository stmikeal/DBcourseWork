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
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    Long id;

    @Column(name = "code")
    Long code;

    @Column(name = "label")
    String label;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;
}
