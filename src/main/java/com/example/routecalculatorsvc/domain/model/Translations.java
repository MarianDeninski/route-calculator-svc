package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
public class Translations {
    Map<String, Translation> translations = new HashMap<>();

    @JsonAnySetter
    public void setTranslations(final String key,final Translation value) {
        translations.put(key, value);
    }

}
