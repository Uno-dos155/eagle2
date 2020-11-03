package com.bird.config;

import com.bird.service.PersonService;
import com.bird.util.PersonValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.mockito.Mockito.mock;

@Configuration
public class TestConfig {
    @Bean
public PersonValidator personValidator(){
        return new PersonValidator();
    }
    @Bean
PersonService personService(){
        return mock(PersonService.class);
    }
}
