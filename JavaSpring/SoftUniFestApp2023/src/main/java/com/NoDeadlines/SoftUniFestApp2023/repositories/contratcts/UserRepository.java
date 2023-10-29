package com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts;



import com.NoDeadlines.SoftUniFestApp2023.models.BusinessUser;
import com.NoDeadlines.SoftUniFestApp2023.models.User;

import java.util.List;

public interface UserRepository {

    // User methods

    public User get(int id);
    BusinessUser get(String username);

    List<BusinessUser> getBusinessUsers();



    void createBusinessUser(BusinessUser user);




}