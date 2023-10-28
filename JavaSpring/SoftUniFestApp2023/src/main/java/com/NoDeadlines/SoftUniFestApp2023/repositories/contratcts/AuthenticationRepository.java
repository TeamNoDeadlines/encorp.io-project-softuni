package com.NoDeadlines.SoftUniFestApp2023.repositories.contratcts;


import com.NoDeadlines.SoftUniFestApp2023.models.UserSession;

public interface AuthenticationRepository {
     /**
      * Get UserSession Object by object id
      * @param id the id of the UserSession
      * @return UserSession object
      */
     UserSession getSession(int id);

     /**
      * Get UserSession by uuid
      * @param uuid the uuid of the UserSession
      * @return UserSession
      */
     UserSession getSession(String uuid);

     /**
      * Deletes a UserSession
      * @param session UserSession to delete
      */
     void deleteSession(UserSession session);

     /**
      * Creates a UserSession with a User id
      * @param id id of the user whose session this will be
      */
     void createSession(int id);


}
