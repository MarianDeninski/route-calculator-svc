package com.example.routecalculatorsvc.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class RouteResult {
    List<String> route;
}
