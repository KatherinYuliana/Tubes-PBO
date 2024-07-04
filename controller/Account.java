package controller;

import java.lang.ModuleLayer.Controller;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Flow.Publisher;

import model.Admin;
import model.Person;
import model.User;

public class Account {
    private static Account instance;

    static DatabaseHandler conn = new DatabaseHandler();

    public Account() {

    }

    public static Account getInstance() {
        if (instance == null) {
            instance = new Account();
        }
        return instance;
    }

    public Person getAccount(String username, String password) {
        conn.connect();
        String queryUser = "SELECT * FROM person WHERE username = ? AND password = ? AND status = 'user'";
        String queryAdmin = "SELECT * FROM person WHERE username = ? AND password = ? AND status = 'admin'";

        Person person = null;

        try {
            // Check for user
            PreparedStatement userStatement = conn.con.prepareStatement(queryUser);
            userStatement.setString(1, username);
            userStatement.setString(2, password);
            ResultSet userResultSet = userStatement.executeQuery();

            if (userResultSet.next()) {
                User user = new User();
                //user.s
                user.setId(userResultSet.getInt("id"));
                user.setUsername(userResultSet.getString("username"));
                user.setPassword(userResultSet.getString("password"));
                user.setStatus(userResultSet.getString("status"));
                //user.setStatus(AccountStatus.valueOf(rsUser.getString("user_status")));
                // user.setWallet(rsUser.getDouble("wallet"));
                person = user;
            }

            // Check for admin if not found
            if (person == null) {
                PreparedStatement adminStatement = conn.con.prepareStatement(queryAdmin);
                adminStatement.setString(1, username);
                adminStatement.setString(2, password);
                ResultSet adminResultSet = adminStatement.executeQuery();

                if (adminResultSet.next()) {
                    Admin admin = new Admin();
                    admin.setId(adminResultSet.getInt("id"));
                    admin.setUsername(adminResultSet.getString("username"));
                    admin.setPassword(adminResultSet.getString("password"));
                    admin.setStatus(adminResultSet.getString("status"));
                    //admin.setStatus(AccountStatus.valueOf(rsAdmin.getString("admin_status")));
                    person = admin;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        conn.disconnect();
        return person;
    }

    public Account getUser(String username, String password) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }
}
