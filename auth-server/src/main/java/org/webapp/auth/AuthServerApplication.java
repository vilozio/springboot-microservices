package org.webapp.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.webapp.auth.consumer.Receiver;
import org.webapp.auth.entity.Account;
import org.webapp.auth.entity.Role;
import org.webapp.auth.service.AccountService;

import java.util.LinkedList;
import java.util.List;

@EnableEurekaClient
@SpringBootApplication
public class AuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public StringJsonMessageConverter jsonConverter() {
		return new StringJsonMessageConverter();
	}

	@Bean
	public Receiver receiver() {
		return new Receiver();
	}

	@Bean
	CommandLineRunner init(
			AccountService accountService
	) {
		List<Account> accountsList = new LinkedList<>();

		Account user = new Account();
		user.setUsername("user");
		user.setPassword("password");

		accountsList.add(user);

		Account admin = new Account();
		admin.setUsername("admin");
		admin.setPassword("password");
		admin.grantAuthority(Role.ROLE_ADMIN);

		accountsList.add(admin);

		return (evt) -> accountsList.forEach(
				accountService::registerUser
		);
	}
}
