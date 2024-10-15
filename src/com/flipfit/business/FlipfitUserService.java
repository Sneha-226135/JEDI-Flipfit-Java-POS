package com.flipfit.business;

import com.flipfit.dao.FlipfitUserDAOImpl;
import com.flipfit.dao.FlipfitUserDAOInterface;

/**
 * Service class implementing FlipFitUserInterface to manage user operations.
 */
public class FlipfitUserService implements FlipfitUserInterface {

    FlipfitUserDAOInterface userDAO = new FlipfitUserDAOImpl();

    /**
     * Authenticates a user based on email, password, and role ID.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @param roleId   The role ID of the user.
     * @return An integer representing the user's authentication status.
     */
    public int authenticateUser(String email, String password, int roleId) {
        try {
            return userDAO.authenticateUser(email, password, roleId);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    /**
     * Creates a new user with the specified email, password, and role ID.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @param roleId   The role ID of the user.
     * @return The user ID of the created user, or 0 if creation fails.
     */
    public int createUser(String email, String password, int roleId) {
        int userId = userDAO.createUser(email, password, roleId);
        if (userId > 0) {
            System.out.println("User created");
            return userId;
        } else {
            System.out.println("User creation failed");
            return 0;
        }
    }
}
