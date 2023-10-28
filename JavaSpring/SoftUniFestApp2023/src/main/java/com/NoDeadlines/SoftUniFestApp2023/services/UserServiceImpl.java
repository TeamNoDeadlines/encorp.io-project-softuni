package com.NoDeadlines.SoftUniFestApp2023.services;

import com.NoDeadlines.SoftUniFestApp2023.models.BusinessUser;
import com.NoDeadlines.SoftUniFestApp2023.models.User;
import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.UserRepository;
import com.NoDeadlines.SoftUniFestApp2023.services.contracts.AuthenticationService;
import com.NoDeadlines.SoftUniFestApp2023.services.contracts.UserService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final AuthenticationService authenticationService;



    @Autowired
    public UserServiceImpl(UserRepository repository, AuthenticationService authenticationService) {
        this.repository = repository;
        this.authenticationService = authenticationService;
    }


    @Override
    public List<BusinessUser> getBusinessUsers() {
        return repository.getBusinessUsers();
    }

    @Override
    public void createBusinessUser(BusinessUser user, String userToken) {
//        if (userToken == null)
//            throw new UnauthorizedOperationException("Only anonymous users or admins can create users");
//
//        if (!user.isAdmin() )
//            throw new UnauthorizedOperationException("Only admins may have phone numbers");
        repository.createBusinessUser(user);
    }

    @Override
    public User get(String username, String pass) {
        return null;
    }


}
