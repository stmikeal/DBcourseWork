package com.example.dbcoursework.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "common_file")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "claim_ref")
    Long claimRef;

    @Column(name = "name")
    String name;

    @Column(name = "data")
    String data;
}
