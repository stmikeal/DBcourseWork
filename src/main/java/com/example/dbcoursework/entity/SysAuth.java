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
@Table(name = "sys_auth")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SysAuth {
    @Id
    Long id;

    @Column(name = "member_ref")
    Long memberRef;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "last_login")
    LocalDateTime lastLogin;
}
