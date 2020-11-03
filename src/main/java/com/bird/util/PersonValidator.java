package com.bird.util;

import com.bird.model.Person;
import com.bird.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Autowired
    private PersonService personService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(personService.getPersonByEmail(person.getEmail())!=null){
        errors.rejectValue("email", "This email already in use");}
    }

    }



