package com.example.dbcoursework.entity.local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ClaimEntity {
    Long type;
    Long memberOut;
    String data;
}
