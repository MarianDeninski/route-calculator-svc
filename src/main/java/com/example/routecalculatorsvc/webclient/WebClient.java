package com.example.routecalculatorsvc.webclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WebClient {
    private static final String URL = "https://raw.githubusercontent.com/mledoze/countries/master/countries.json";

    private final RestTemplate restTemplate;

    public WebClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

    public String getAllCountries() {
        return restTemplate.getForObject(URL, String.class);
    }
}
