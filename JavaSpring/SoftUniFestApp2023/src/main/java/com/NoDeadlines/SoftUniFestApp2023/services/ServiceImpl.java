package com.NoDeadlines.SoftUniFestApp2023.services;


import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.Repository;
import com.NoDeadlines.SoftUniFestApp2023.services.contracts.Service;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service

public class ServiceImpl implements Service {

    private final Repository repository;


    @Autowired
    public ServiceImpl(Repository repository) {
        this.repository = repository;
    }


   @Override
    public String getName(){
        return repository.getName();


    }


}
