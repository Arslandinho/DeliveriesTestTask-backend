package com.example.delivery_register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.example.delivery_register.service"})
@EntityScan("com.example.delivery_register.model")
@EnableJpaRepositories("com.example.delivery_register.repository")
public class DeliveryRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeliveryRegisterApplication.class, args);
    }

}
