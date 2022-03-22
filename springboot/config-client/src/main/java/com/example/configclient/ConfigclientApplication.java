package com.example.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RefreshScope
@RestController 
public class ConfigclientApplication {
   @Autowired
   private ConfigProperties config;
   
   public static void main(String[] args) {
      SpringApplication.run(ConfigclientApplication.class, args);
   }
   @RequestMapping(value = "/")
   public String welcomeText() {
      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<String> response = restTemplate.getForEntity(config.getServiceUri(), String.class); 

      return config.getMessage() + " || service message: " + response.getBody();
   }
}