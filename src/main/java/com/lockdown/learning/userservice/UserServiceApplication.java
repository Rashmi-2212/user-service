package com.lockdown.learning.userservice;

import com.lockdown.learning.userservice.config.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableWebSecurity
@EnableSwagger2
@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.lockdown.learning.userservice.repository")
@EnableConfigurationProperties({ApplicationProperties.class})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
