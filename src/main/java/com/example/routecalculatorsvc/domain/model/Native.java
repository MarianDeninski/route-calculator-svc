package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;
@Value
class Native {
    Map<String, Translation> aNative = new HashMap<>();

    @JsonAnySetter
    public void setaNative(String key, Translation value) {
        aNative.put(key,value);
    }
}