package com.example.dbcoursework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "sys_auth")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SysAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "member")
    Long member;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "last_login")
    LocalDateTime lastLogin;
}
