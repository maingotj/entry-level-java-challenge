package com.challenge.api.repository;

import com.challenge.api.model.EmployeeImp;
import java.time.Instant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> { // loads in dummy data
            log.info("Preloading "
                    + repository.save(new EmployeeImp(
                            "John",
                            "Doe",
                            "John Jim Doe",
                            10000,
                            13,
                            "Senior Manager",
                            "JohnD@gmail.com",
                            Instant.parse("2021-01-01T10:00:00Z"),
                            null)));
            log.info("Preloading "
                    + repository.save(new EmployeeImp(
                            "Jane",
                            "Doe",
                            "Jane Smith DOe",
                            1000000,
                            13,
                            "Senior Manager",
                            "JohnD@gmail.com",
                            Instant.parse("2021-01-01T10:00:00Z"),
                            null)));
        };
    }
}
