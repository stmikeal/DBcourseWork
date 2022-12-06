package com.example.dbcoursework.entity.local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SecureDescriptionEntity {
    SecureEntity secure;
    DescriptionEntity entity;
}
