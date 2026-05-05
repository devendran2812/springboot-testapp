package com.example.testapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ExternalService {

    private final RestTemplate restTemplate;

    public String callExternalApi() {
        return restTemplate.getForObject(
            "https://jsonplaceholder.typicode.com/posts/1",
            String.class
        );
    }
}