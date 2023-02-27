package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
class Name {
    String common;
    String official;
    Native aNative;

    @JsonCreator
    public Name(@JsonProperty ("common") String common,
                @JsonProperty ("official") String official,
                @JsonProperty ("native") Native aNative) {
        this.common = common;
        this.official = official;
        this.aNative = aNative;
    }
}