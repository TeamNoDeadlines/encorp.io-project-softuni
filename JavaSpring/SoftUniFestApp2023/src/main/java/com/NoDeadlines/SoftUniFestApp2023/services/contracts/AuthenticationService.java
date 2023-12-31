package com.NoDeadlines.SoftUniFestApp2023.services.contracts;


import com.NoDeadlines.SoftUniFestApp2023.models.User;
import com.NoDeadlines.SoftUniFestApp2023.models.UserSession;

public interface AuthenticationService {
    /**
     * Takes a username and password checks against the database and if valid returns a UserSession
     * If the session is expired deletes old session and creates a new one
     * @param username
     * @param password
     * @return UserSession
     */
    UserSession login(String username, String password);

    /**
     * Deletes user session by uuid
     * @param uuid
     */
    void logout(String uuid);

    /**
     * Gets a User from uuid (UserSession uuid)
     * @param uuid
     * @return User
     */
    User getUserFromUUID(String uuid);
}
