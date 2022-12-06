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
@Table(name = "claim_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimType {
    @Id
    Long id;

    @Column(name = "code")
    Long code;

    @Column(name = "label")
    String label;

    @Column(name = "description")
    String description;
}
