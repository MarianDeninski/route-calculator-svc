package com.example.routecalculatorsvc.service;

import com.example.routecalculatorsvc.domain.model.Country;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CountryService {
    Country[] getAllCountries() throws JsonProcessingException;

    List<String> getRoute(String origin, String destination) throws JsonProcessingException;

}
