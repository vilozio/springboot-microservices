package org.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.webapp.kafka.consumer.Receiver;

@EnableEurekaClient
@SpringBootApplication
public class MailAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailAppApplication.class, args);
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
    public JavaMailSenderImpl mailSender() {
        return new JavaMailSenderImpl();
    }
}
