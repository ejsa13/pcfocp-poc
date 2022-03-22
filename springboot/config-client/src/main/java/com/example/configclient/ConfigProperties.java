package com.example.configclient;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "welcome")
public class ConfigProperties {
    private String message = "Welcome from Spring local";
    private String serviceUri = "http://localhost:9000/message";

    public void setMessage(String value) {
        message = value;
    }

    public String getMessage() {
        return message;
    }

    public void setServiceUri(String value) {
        serviceUri = value;
    }

    public String getServiceUri() {
        return serviceUri;
    }
}
