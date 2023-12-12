package org.wso2.sample.config;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {

        CloseableHttpClient httpclient = HttpClients.custom()
                // Limit total time to live to 1 minute
                .setConnectionTimeToLive(10, TimeUnit.SECONDS)
                // evict expired connections proactively
                .evictExpiredConnections()
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpclient);

        // Set timeout parameters if necessary
        requestFactory.setConnectTimeout(5000); // Example value
        requestFactory.setReadTimeout(5000);    // Example value

        return new RestTemplate(requestFactory);
    }
}
