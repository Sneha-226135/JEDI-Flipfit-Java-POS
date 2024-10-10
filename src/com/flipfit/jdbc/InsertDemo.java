package com.flipfit.jdbc;

import java.sql.*;

public class InsertDemo {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit-schema","root","test@123");
            PreparedStatement stmt=con.prepareStatement("insert into UserTable (userId, UserName, UserEmail, UserPassword, UserRole) values(?,?,?,?,?)");
            stmt.setInt(1,102);//1 specifies the first parameter in the query
            stmt.setString(2,"Shaitan");
            stmt.setString(3,"shaitan@gmail.com");
            stmt.setString(4,"shaitan@123");
            stmt.setString(5,"customer");

            int i=stmt.executeUpdate();
            System.out.println(i+" records inserted");

            con.close();

        }catch(Exception e){ System.out.println(e);}

    }
}
