package com.NoDeadlines.SoftUniFestApp2023.repositories;


import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Repository
public class RepositoryImpl implements Repository {


    private final SessionFactory sessionFactory;

    @Autowired
    public RepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public String getName(){

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            NativeQuery<String> query = session.createNativeQuery
                    ( "select email\n" +
                            "from `user`\n" +
                            "where user_id = 1");

            session.getTransaction().commit();

            return query.getSingleResult();

        }
    }



}
