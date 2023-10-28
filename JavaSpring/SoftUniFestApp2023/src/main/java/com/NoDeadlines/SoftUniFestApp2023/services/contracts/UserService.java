package com.NoDeadlines.SoftUniFestApp2023.services.contracts;

import com.NoDeadlines.SoftUniFestApp2023.models.BusinessUser;
import com.NoDeadlines.SoftUniFestApp2023.models.User;


import java.util.List;

public interface UserService {

    public List<BusinessUser> getBusinessUsers();

    void createBusinessUser(BusinessUser user, String userToken);


    User get(String username, String pass);

}
