package com.example.routecalculatorsvc.service;

import com.example.routecalculatorsvc.domain.model.Country;
import com.example.routecalculatorsvc.domain.model.RouteResult;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CountryService {
    Country[] getAllCountries() throws JsonProcessingException;

    RouteResult getRoute(String origin, String destination) throws JsonProcessingException;

}
