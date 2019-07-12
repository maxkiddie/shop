package com.kiddie.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
@RestController
public class ZipkinApp {
	public static void main(String[] args) {
		SpringApplication.run(ZipkinApp.class, args);
	}

	@RequestMapping("hi")
	public String hi() {
		return "hello,world!";
	}
}
