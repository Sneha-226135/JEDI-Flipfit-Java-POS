package com.flipfit.dao;


import java.sql.*;

/**
 * Implementation of FlipFitUserDAOInterface for user authentication and creation.
 */
public class FlipfitUserDAOImpl implements FlipfitUserDAOInterface {
    /**
     * Authenticates a user based on email, password, and role ID.
     *
     * @param email     The email of the user to authenticate.
     * @param password  The password of the user.
     * @param roleId    The role ID of the user (e.g., customer, gym owner).
     * @return          The user ID if authentication is successful; otherwise, 0.
     */
    @Override
    public int authenticateUser(String email, String password, int roleId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit-schema", "root", "sneha1808");
            String query = "SELECT userPassword, userId FROM users WHERE userEmail = ? and roleId = ?";

            stmt = con.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setInt(2, roleId);

            rs = stmt.executeQuery();
            if (rs.next()) {
                String storedPassword = rs.getString("userPassword");
                if (password.equals(storedPassword)){
                    return rs.getInt("userId");
                }
                else {
                	return 0;
                	}
            } else {
            	
            	return 0;
                
            }
        } 
        catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return 0;
    }
    /**
     * Creates a new user entry in the database.
     *
     * @param email     The email of the user.
     * @param password  The password of the user.
     * @param roleId    The role ID of the user (e.g., customer, gym owner).
     * @return          The generated user ID if creation is successful; otherwise, 0.
     */

    public int createUser(String email, String password, int roleId){
        Connection con = null;
        PreparedStatement stmtUser = null;
        int userId=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit-schema", "root", "sneha1808");

            con.setAutoCommit(false);
            String queryUser = "INSERT INTO users (userEmail, userPassword, roleId) VALUES (?, ?, ?)";
            stmtUser = con.prepareStatement(queryUser, Statement.RETURN_GENERATED_KEYS);

            stmtUser.setString(1, email);
            stmtUser.setString(2, password);
            stmtUser.setInt(3, roleId);

            int userInsertCount = stmtUser.executeUpdate();

            if (userInsertCount > 0) {
                ResultSet generatedKeys = stmtUser.getGeneratedKeys();
                if (generatedKeys.next()) {
                    userId = generatedKeys.getInt(1);
                    System.out.println(userInsertCount + " user records inserted");
                }
            } else {
                System.out.println("User insertion failed.");
            }
            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
        }
        return userId;
    }
}
