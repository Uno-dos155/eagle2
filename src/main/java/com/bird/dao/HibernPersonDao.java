package com.bird.dao;

import com.bird.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class HibernPersonDao {


    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession(){
        return sessionFactory.openSession();
    }

    public List<Person> personList(){
        return currentSession().createQuery("from Person ", Person.class).list();
    }
}
