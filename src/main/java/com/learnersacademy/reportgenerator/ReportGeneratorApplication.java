package com.learnersacademy.reportgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learnersacademy.reportgenerator.dao.DatabaseConnector;

@SpringBootApplication
public class ReportGeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportGeneratorApplication.class, args);

	}

}
