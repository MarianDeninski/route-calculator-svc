package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
class NameDetail {
    String common;
    String official;

    @JsonCreator
    public NameDetail(@JsonProperty ("common") String common,
                      @JsonProperty ("official") String official) {
        this.common = common;
        this.official = official;
    }
}