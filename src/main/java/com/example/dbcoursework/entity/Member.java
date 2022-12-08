package com.example.dbcoursework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "short_name")
    String shortName;

    @Column(name = "inner_id")
    String innerId;

    @Column(name = "url")
    String url;

    @Column(name = "full_name")
    String fullName;
}
