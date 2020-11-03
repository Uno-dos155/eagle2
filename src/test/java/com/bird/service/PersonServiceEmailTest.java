package com.bird.service;

import com.bird.config.TestConfig;
import com.bird.model.Person;
import com.bird.util.PersonValidator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
class PersonServiceEmailTest {

    @Autowired
    PersonService personService;
    @Autowired
    PersonValidator personValidator;

    private static final String personEmail = "asd@gmail.com";
    private static final Person person = mock(Person.class);

    @BeforeAll
    public static void setup() {
        when(person.getEmail()).thenReturn(personEmail);
    }

    @Test
    public void validateShouldAcceptUserWithNewEmail() {
        when(personService.getPersonByEmail(personEmail)).thenReturn((null));
        Errors errors = mock(Errors.class);
        personValidator.validate(person, errors);
        verify(errors, never()).rejectValue(eq("email"), anyString());
    }

    @Test
    public void validateShouldRejectUserWithAlreadyUsedEmail() {
        when(personService.getPersonByEmail(personEmail)).thenReturn(person);
        Errors errors = mock(Errors.class);
        personValidator.validate(person, errors);
        verify(errors, times(1))
                .rejectValue(eq("email"), anyString());
    }

}