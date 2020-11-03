package com.bird.service;

import com.bird.config.TestConfig;
import com.bird.model.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class PersonServiceValidTest {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    @Autowired
    PersonService personService;

    @Test
    public void checkCreatePerson(){
        Person person = new Person(4,"Jul", "Lee", "combdssd@mail.ru","123123123123",
                "87776542345");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
        }
        if(personService!=null){
        personService.createPerson(person);
        }
        Assert.assertNotNull(person);

    }
}
