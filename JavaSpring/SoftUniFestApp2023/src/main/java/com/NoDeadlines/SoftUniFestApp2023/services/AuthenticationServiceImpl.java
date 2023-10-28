//package com.web.project.webprojecttelerik.services;
//
//import com.web.project.webprojecttelerik.exceptions.ForbiddenActionException;
//import com.web.project.webprojecttelerik.exceptions.UnauthorizedOperationException;
//import com.web.project.webprojecttelerik.models.User;
//import com.web.project.webprojecttelerik.models.UserSession;
//import com.web.project.webprojecttelerik.repositories.contratcts.AuthenticationRepository;
//import com.web.project.webprojecttelerik.repositories.contratcts.UserRepository;
//import com.web.project.webprojecttelerik.services.contracts.AuthenticationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import javax.persistence.NoResultException;
//import java.sql.*;
//import java.time.Instant;
//
//@Service
//public class AuthenticationServiceImpl implements AuthenticationService {
//
//    private final AuthenticationRepository repository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public AuthenticationServiceImpl(AuthenticationRepository repository, UserRepository userRepository){
//        this.repository = repository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserSession login(String username, String password) {
//
//        User user = userRepository.get(username);
//        if(!user.getPassword().equals(password))
//            throw new UnauthorizedOperationException("Password mismatch");
//        UserSession session = repository.getSession(user.getId());
//        Timestamp currentTime = Timestamp.from(Instant.now());
//
//        if(currentTime.after(session.getTimestamp())){
//            repository.deleteSession(session);
//            return repository.getSession(user.getId());
//        }
//        return session;
//    }
//
//    @Override
//    public void logout(String uuid) {
//        try{
//            UserSession userSession = repository.getSession(uuid);
//            repository.deleteSession(userSession);
//        }catch (NoResultException e){
//            throw new ForbiddenActionException("User with session id " + uuid + "not logged in" );
//        }
//    }
//
//    @Override
//    public User getUserFromUUID(String uuid) {
//        UserSession userSession = repository.getSession(uuid);
//        Timestamp currentTime = Timestamp.from(Instant.now());
//
//        if(currentTime.after(userSession.getTimestamp()))
//        {
//            repository.deleteSession(userSession);
//            throw new UnauthorizedOperationException("Session expired, please login");
//        }
//
//        return userRepository.get(userSession.getUser());
//    }
//
//
//}
