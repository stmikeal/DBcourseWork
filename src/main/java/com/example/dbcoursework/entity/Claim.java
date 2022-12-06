package com.example.dbcoursework.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "claim")
public class Claim {
    @Id
    Long id;

    @Column(name = "pair")
    Long pair;

    @Column(name = "status")
    Long status;

    @Column(name = "type")
    Long type;

    @Column(name = "member_in")
    Long memberId;

    @Column(name = "member_out")
    Long memberOut;

    @Column(name = "data")
    String data;

    @Column(name = "created_date")
    LocalDateTime createdDate;
}
