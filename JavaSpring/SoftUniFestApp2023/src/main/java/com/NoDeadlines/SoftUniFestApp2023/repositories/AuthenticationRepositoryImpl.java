package com.NoDeadlines.SoftUniFestApp2023.repositories;


import com.NoDeadlines.SoftUniFestApp2023.models.UserSession;
import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.UserRepository;

import com.NoDeadlines.SoftUniFestApp2023.exceptions.UnauthorizedOperationException;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts.AuthenticationRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Repository
public class AuthenticationRepositoryImpl implements AuthenticationRepository {


    private final SessionFactory sessionFactory;

    private final UserRepository userRepository;
    @Autowired
    public AuthenticationRepositoryImpl(SessionFactory sessionFactory, UserRepository userRepository){
       this.sessionFactory = sessionFactory;
       this.userRepository = userRepository;
//       ClearSessions();
    }

    @Override
    public UserSession getSession(int id) {

        try(Session session = sessionFactory.openSession()){
            Query<UserSession> query = session.createQuery("from UserSession where user_id=:id");
            query.setParameter("id", id);
            UserSession userSession = query.getSingleResult();
            return userSession;
        }catch (NoResultException e){
                createSession(id);
                return getSession(id);

        }
    }

    @Override
    public UserSession getSession(String uuid) {
        try (Session session = sessionFactory.openSession()){
            Query<UserSession> query = session.createQuery("from UserSession where uuid=:uuid");
            query.setParameter("uuid", uuid);
            return query.getSingleResult();
        }catch (NoResultException e){
            throw new UnauthorizedOperationException("No user session found");
        }

    }

    @Override
    public void deleteSession(UserSession userSession) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(userSession);
            session.getTransaction().commit();
        }
    }

    @Override
    public void createSession(int id) {
        try(Session session = sessionFactory.openSession())
        {
            UserSession userSession = new UserSession();
            userSession.setUser(userRepository.get(id).getId());
            userSession.setUuid(UUID.randomUUID().toString());
            Timestamp timestamp = Timestamp.from(Instant.now());
            timestamp.setTime(timestamp.getTime() + ((23 * 60 * 60)* 1000));
            userSession.setTimestamp(timestamp);
            session.save(userSession);
        }
    }

    private void ClearSessions()
    {
        try(Session session= sessionFactory.openSession()){
            session.beginTransaction();
            NativeQuery query = session.createNativeQuery("delete from webAppForum.sessions");
            query.getResultList();
            session.close();
        }
    }

}
