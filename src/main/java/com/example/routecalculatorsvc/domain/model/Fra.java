package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Fra {

    String f;
    String m;

    @JsonCreator
    public Fra(@JsonProperty("f") String f,
               @JsonProperty("m") String m) {
        this.f = f;
        this.m = m;
    }
}
