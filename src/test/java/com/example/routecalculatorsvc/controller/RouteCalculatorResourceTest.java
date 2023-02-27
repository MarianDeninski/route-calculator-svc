package com.example.routecalculatorsvc.controller;

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
        String origin = "BGR";
        String destination = "ITA";
        List<String> expectedPath = Arrays.asList("BGR", "ROU", "HUN", "AUT", "ITA");
        when(countryService.getRoute(origin, destination)).thenReturn(expectedPath);
        // act
        List<String> actualPath = countryController.getRoutingInformation(origin, destination);

        // assert
        assertEquals(expectedPath, actualPath);
    }

    @Test
    public void getRoutingInformation_throwsBadRequestException_whenInvalidInput() throws JsonProcessingException {
        // arrange
        String origin = "USA";
        String destination = "Mexico";
        when(countryService.getRoute(origin, destination)).thenReturn(null);

        // act and assert
        assertThrows(BadRequestException.class, () -> countryController.getRoutingInformation(origin, destination));
    }
}