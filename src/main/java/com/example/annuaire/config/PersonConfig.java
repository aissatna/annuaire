package com.example.annuaire.config;

import com.example.annuaire.model.Person;
import com.example.annuaire.service.IPersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(IPersonService personService) {
        return args -> {
            personService.addPerson(new Person("Lee", "Bruce", "1741602653", "Hong Kong"));
            personService.addPerson(new Person("Daniel", "Craig", "6886286069", "Londres"));
            personService.addPerson(new Person("Tom", "Cruise", "6912633461", "New York"));

        };
    }
}
