package com.bird.dao;

import com.bird.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {

  /*  @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> getAll() {
        return jdbcTemplate.query(
                "select * from person",
                new BeanPropertyRowMapper<>(Person.class)
        );
    }*/

  /*  List<Person> personList;

    {
        personList= new ArrayList<>();
        personList.add(new Person(1,"Sas"));
        personList.add(new Person(2,"Saserer"));
        personList.add(new Person(3,"KakSaserer"));
    }

    public List<Person> getAllPerson(){
        return personList;
    }*/
}
