package com.NoDeadlines.SoftUniFestApp2023.repositories;


import com.NoDeadlines.SoftUniFestApp2023.models.BusinessUser;
import com.NoDeadlines.SoftUniFestApp2023.models.User;
import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.UserRepository;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

//import jakarta.persistence.*;

import java.util.*;


@Repository
@PropertySource("classpath:application.properties")
public class UserRepositoryImpl implements UserRepository {


    private final SessionFactory sessionFactory;

    @Autowired
    public UserRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public User get(String username) {
        return new User() ;
    }

    @Override
     public List<BusinessUser> getBusinessUsers( ){
        try (Session session = sessionFactory.openSession()) {
//            Query<BusinessUser> query = session.createQuery("from business_user", BusinessUser.class);
//            return query.list();
            NativeQuery<BusinessUser> query = session.createNativeQuery("select * \n" +
                                                                            "FROM business_user " )   ;
            return query.getResultList();
        }
    }

    @Override
    public User get(int id) throws NoResultException {
        try (Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }
    }

    @Override
    public void createBusinessUser(BusinessUser user) {
        try (Session session = sessionFactory.openSession()) {
            session.persist(user);
        }
    }


}
