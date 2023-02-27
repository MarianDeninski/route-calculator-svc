package com.example.routecalculatorsvc.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class IDD {
    String root;
    List<String> suffixes;

    @JsonCreator
    public IDD(@JsonProperty ("root") String root,
               @JsonProperty ("suffixes") List<String> suffixes) {
        this.root = root;
        this.suffixes = suffixes;
    }
}
