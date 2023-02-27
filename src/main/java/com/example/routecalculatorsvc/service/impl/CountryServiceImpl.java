package com.example.routecalculatorsvc.service.impl;

import com.example.routecalculatorsvc.domain.model.Country;
import com.example.routecalculatorsvc.domain.model.RouteResult;
import com.example.routecalculatorsvc.service.CountryService;
import com.example.routecalculatorsvc.webclient.WebClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

@Service
public class CountryServiceImpl implements CountryService {

    private final WebClient webClient;

    private final ObjectMapper objectMapper;

    public CountryServiceImpl(final WebClient webClient,final ObjectMapper objectMapper) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public Country[] getAllCountries() throws JsonProcessingException {
        final String countries = webClient.getAllCountries();
        return objectMapper.readValue(countries, Country[].class);
    }

    @Override
    public RouteResult getRoute(final String origin, final String destination) throws JsonProcessingException {

        final Country[] countries = getAllCountries();
        final TreeMap<String, Country> cashDatabase = createCashDatabase(countries);

        final Queue<String> queue = new LinkedList<>();
        final Set<String> visited = new HashSet<>();
        final Map<String, String> path = new HashMap<>();

        queue.add(origin);
        visited.add(origin);

        while (!queue.isEmpty()) {
            final String current = queue.poll();
            if (current.equals(destination)) {
                return RouteResult.builder()
                        .route(constructPath(path, origin, destination))
                        .build();
            }
            for (String neighbor : cashDatabase.get(current).getBorders()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    path.put(neighbor, current);
                }
            }
        }
        return null;
    }

    private static List<String> constructPath(final Map<String, String> path,
                                              final String origin,
                                              String destination) {
        final List<String> result = new ArrayList<>();
        result.add(destination);
        while (!destination.equals(origin)) {
            destination = path.get(destination);
            result.add(destination);
        }
        Collections.reverse(result);
        return result;
    }

    private TreeMap<String, Country> createCashDatabase(final Country[] countries) {
        final TreeMap<String, Country> map = new TreeMap<>();
        Arrays.stream(countries).forEach(a -> map.put(a.getCca3(), a));
        return map;
    }
}
