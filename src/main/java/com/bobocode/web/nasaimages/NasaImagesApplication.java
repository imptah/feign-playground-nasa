package com.bobocode.web.nasaimages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NasaImagesApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasaImagesApplication.class, args);
	}

}
