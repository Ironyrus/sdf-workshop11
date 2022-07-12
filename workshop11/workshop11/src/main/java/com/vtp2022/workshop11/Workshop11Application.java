package com.vtp2022.workshop11;

import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
/*
 *  
Compile application
>>> mvn compile
• Package application including compile
• JAR file is in target directory
>>> mvn package
• Run application
>>> mvn spring-boot:run
• Run JAR file
java -jar day12-0.0.1-SNAPSHOT.jar
• Clean build artifacts
mvn clean

Run with port numbers specified
>>> mvn spring-boot:run -Dspring-boot.run.arguments=--port=8080
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Workshop11Application {

	private static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);

	// @Bean
	// public CommonsRequestLoggingFilter log() {
		
	// 	CommonsRequestLoggingFilter logger = 
	// 		new CommonsRequestLoggingFilter();
	// 	logger.setIncludeClientInfo(true);
	// 	logger.setIncludeQueryString(true);
	// 	return logger;
	// }

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Workshop11Application.class);
		logger.info("Web App");
		String port = "3000";
		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
		System.out.println(cliOpts.getSourceArgs());
		if(cliOpts.containsOption("port")){
			port = cliOpts.getOptionValues("port").get(0);
		}
		// 	System.out.println("TEST" + cliOpts.getOptionValues("--port").get(0));
		logger.info("cliOpts > " + port);
		app.setDefaultProperties(Collections.singletonMap("server.port", port));
		System.out.println("Application started on port: " + port);
		app.run(args);
		
		
		//Start without needing to specify ports in args
		//SpringApplication.run(Workshop11Application.class, args);
	}

}
