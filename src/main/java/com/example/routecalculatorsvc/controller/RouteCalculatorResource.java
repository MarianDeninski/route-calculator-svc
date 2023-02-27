package com.example.routecalculatorsvc.controller;

import com.example.routecalculatorsvc.domain.model.RouteResult;
import com.example.routecalculatorsvc.exception.BadRequestException;
import com.example.routecalculatorsvc.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RouteCalculatorResource {
    private final CountryService countryService;

    public RouteCalculatorResource(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/routing/{origin}/{destination}")
    public RouteResult getRoutingInformation(@PathVariable String origin,
                                             @PathVariable String destination) throws JsonProcessingException {

        final RouteResult path = countryService.getRoute(origin, destination);
        if (path == null) {
            log.error("No borders between origin and destination");
            throw new BadRequestException("No borders between origin and destination");
        }
        return path;
    }
}
