package com.example.dbcoursework.dict;

public enum ClaimStatusDict {
    NEW(1L),
    IN_PROGRESS(2L),
    DONE(3L),
    ERROR_BY_DELETE_USER(4L),
    ERROR_BY_DELETE_MEMBER(5L);

    public final Long id;

    ClaimStatusDict(Long id) {
        this.id = id;
    }
}
