package com.NoDeadlines.SoftUniFestApp2023.controllers;


import com.NoDeadlines.SoftUniFestApp2023.services.contracts.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {

    private final Service service;

    @Autowired
    public Test(Service service ){
        this.service = service;

    }

    @GetMapping("")
    public String getName() {


            return service.getName();


    }


}
