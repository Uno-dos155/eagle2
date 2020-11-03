package com.bird.controller;

import com.bird.dao.HibernPersonDao;
import com.bird.dao.PersonDao;
import com.bird.model.Person;
import com.bird.repository.PersonRepository;
import com.bird.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Main {
    /*
private PersonDao personDao;

    public Main(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GetMapping("/show")
public String allPerson(Model model){
        model.addAttribute("users", personDao.getAll());
        return "users";
}*/
/*
    private HibernPersonDao hibernPersonDao;

    public Main(HibernPersonDao hibernPersonDao) {
        this.hibernPersonDao = hibernPersonDao;
    }

    @GetMapping("/show")
    public String allPerson(Model model) {
        model.addAttribute("users", hibernPersonDao.personList());
        return "users";
    }*/

    private PersonService personService;

    public Main(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/show")
    public String allPerson(Model model) {
        model.addAttribute("users", personService.getPersonList());
        return "users";
    }
}
