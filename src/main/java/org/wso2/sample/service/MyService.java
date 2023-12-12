package org.wso2.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

    private final RestTemplate restTemplate;

    @Autowired
    public MyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callBackendService(String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
