package com.NoDeadlines.SoftUniFestApp2023.services;


import com.NoDeadlines.SoftUniFestApp2023.exceptions.ForbiddenActionException;
import com.NoDeadlines.SoftUniFestApp2023.exceptions.UnauthorizedOperationException;
import com.NoDeadlines.SoftUniFestApp2023.models.BusinessUser;
import com.NoDeadlines.SoftUniFestApp2023.models.User;

import com.NoDeadlines.SoftUniFestApp2023.models.UserSession;
import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.AuthenticationRepository;
import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.UserRepository;
import com.NoDeadlines.SoftUniFestApp2023.services.contracts.AuthenticationService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import jakarta.persistence.*;
import java.sql.*;
import java.time.Instant;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationRepository repository, UserRepository userRepository){
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public UserSession login(String username, String password) {

        BusinessUser user = userRepository.get(username);
        if(!user.getPassword().equals(password))
            throw new UnauthorizedOperationException("Password mismatch");
        UserSession session = repository.getSession(user.getId());
        Timestamp currentTime = Timestamp.from(Instant.now());

        if(currentTime.after(session.getTimestamp())){
            repository.deleteSession(session);
            return repository.getSession(user.getId());
        }
        return session;
    }

    @Override
    public void logout(String uuid) {
        try{
            UserSession userSession = repository.getSession(uuid);
            repository.deleteSession(userSession);
        }catch (NoResultException e){
            throw new ForbiddenActionException("User with session id " + uuid + "not logged in" );
        }
    }

    @Override
    public User getUserFromUUID(String uuid) {
        UserSession userSession = repository.getSession(uuid);
        Timestamp currentTime = Timestamp.from(Instant.now());

        if(currentTime.after(userSession.getTimestamp()))
        {
            repository.deleteSession(userSession);
            throw new UnauthorizedOperationException("Session expired, please login");
        }

        return userRepository.get(userSession.getUser());
    }


}
