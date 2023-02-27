package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Demonyms {
    Eng eng;
    Fra fra;

    @JsonCreator
    public Demonyms(@JsonProperty ("eng") Eng eng,
                    @JsonProperty ("fra") Fra fra) {
        this.eng = eng;
        this.fra = fra;
    }
}
