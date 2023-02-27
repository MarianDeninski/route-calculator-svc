package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
public class Languages {
    Map<String, String> map = new HashMap<>();
    @JsonAnySetter
    public void setLanguage(String key, String value) {
        map.put(key, value);
    }
}
