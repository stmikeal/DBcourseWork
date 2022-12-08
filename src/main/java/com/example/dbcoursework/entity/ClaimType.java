package com.example.dbcoursework.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "code")
    Long code;

    @Column(name = "label")
    String label;

    @Column(name = "description")
    String description;
}
