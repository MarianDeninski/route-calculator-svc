package com.example.routecalculatorsvc.controller;

import com.example.routecalculatorsvc.exception.BadRequestException;
import com.example.routecalculatorsvc.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteCalculatorResource {
    private final CountryService countryService;

    public RouteCalculatorResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/routing/{origin}/{destination}")
    public List<String> getRoutingInformation(@PathVariable String origin,
                                              @PathVariable String destination) throws JsonProcessingException {

        final List<String> path =  countryService.getRoute(origin, destination);
        if (path == null) {
            throw new BadRequestException("No borders between origin and destination");
        }
        return path;
    }
}
