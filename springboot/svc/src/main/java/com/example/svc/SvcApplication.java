package com.example.svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvcApplication.class, args);
	}

	@GetMapping(value = "/")
   	public String serviceText() {
      return "message from service";
   }
}
