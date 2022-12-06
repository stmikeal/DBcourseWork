package com.example.dbcoursework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "common_file")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonFile {
    @Id
    Long id;

    @Column(name = "claim_ref")
    Long claimRef;

    @Column(name = "name")
    String name;

    @Column(name = "data")
    String data;
}
