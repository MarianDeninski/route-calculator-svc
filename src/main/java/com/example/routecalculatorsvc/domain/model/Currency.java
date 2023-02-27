package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Currency {
    String name;
    String symbol;

    @JsonCreator
    public Currency(@JsonProperty ("name") String name,
                    @JsonProperty ("symbol") String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
