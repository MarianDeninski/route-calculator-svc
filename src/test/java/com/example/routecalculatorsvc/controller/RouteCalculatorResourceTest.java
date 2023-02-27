package com.example.routecalculatorsvc.controller;

import com.example.routecalculatorsvc.domain.model.RouteResult;
import com.example.routecalculatorsvc.exception.BadRequestException;
import com.example.routecalculatorsvc.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RouteCalculatorResourceTest {

    @Mock
    private CountryService countryService;

    @InjectMocks
    private RouteCalculatorResource countryController;

    @Test
    public void getRoutingInformation_returnsPath_whenValidInput() throws JsonProcessingException {
        // arrange
        final String origin = "BGR";
        final String destination = "ITA";
        final List<String> listResult = Arrays.asList("BGR", "ROU", "HUN", "AUT", "ITA");
        final RouteResult expectedResult = RouteResult.builder().route(listResult).build();
        when(countryService.getRoute(origin, destination)).thenReturn(expectedResult);
        // act
        final RouteResult actualPath = countryController.getRoutingInformation(origin, destination);

        // assert
        assertEquals(expectedResult, actualPath);
    }

    @Test
    public void getRoutingInformation_throwsBadRequestException_whenInvalidInput() throws JsonProcessingException {
        // arrange
        final String origin = "USA";
        final String destination = "Mexico";
        when(countryService.getRoute(origin, destination)).thenReturn(null);

        // act and assert
        assertThrows(BadRequestException.class, () -> countryController.getRoutingInformation(origin, destination));
    }
}