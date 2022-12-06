package com.example.dbcoursework.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "claim")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pair")
    private Long pair;

    @Column(name = "status")
    private Long status;

    @Column(name = "type")
    private Long type;

    @Column(name = "member_in")
    private Long memberIn;

    @Column(name = "member_out")
    private Long memberOut;

    @Column(name = "data")
    private String data;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
