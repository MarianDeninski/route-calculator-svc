package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
public class Currencies {

    Map<String,Currency> currencies = new HashMap<>();

    @JsonAnySetter
    public void setCurrencies(final String key,final Currency value) {
        currencies.put(key, value);
    }
}