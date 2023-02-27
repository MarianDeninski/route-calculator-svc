package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Translation {

    String official;
    String common;

    @JsonCreator
    public Translation(@JsonProperty ("official") String official,
                       @JsonProperty ("common") String common) {
        this.official = official;
        this.common = common;
    }
}
