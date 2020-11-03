package com.bird.service;

import com.bird.model.Person;
import com.bird.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonService() {
    }

    public List<Person> getPersonList(){
        return personRepository.findAll();
    }

    public Person getPersonByEmail(String email){
      Person person = personRepository.findByEmail(email);
      return person;
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }
}
