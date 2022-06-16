package com.example.auth.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

        private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

        public static void main(String[] args) {
            SpringApplication.run(AccessingDataJpaApplication.class);
        }

        @Bean
        public CommandLineRunner demo(userRepository repository) {
            return (args) -> {
                // save a few user
                repository.save(new user("Jack", "Bauer"));
                repository.save(new user("Chloe", "O'Brian"));
                repository.save(new user("Kim", "Bauer"));
                repository.save(new user("David", "Palmer"));
                repository.save(new user("Michelle", "Dessler"));

                // fetch all user
                log.info("User found with findAll():");
                log.info("-------------------------------");
                for (user user : repository.findAll()) {
                    log.info(user.toString());
                }
                log.info("");

                // fetch an individual customer by ID
                user user = repository.findById(1L);
                log.info("User found with findById(1L):");
                log.info("--------------------------------");
                log.info(user.toString());
                log.info("");

                // fetch user by last name
                log.info("User found with findByLastName('Bauer'):");
                log.info("--------------------------------------------");
                repository.findByUsername("Jack").forEach(jack -> {
                    log.info(jack.toString());
                });
                // for (Customer bauer : repository.findByLastName("Bauer")) {
                //  log.info(bauer.toString());
                // }
                log.info("");
            };
        }

    }
            