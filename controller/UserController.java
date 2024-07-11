package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

import model.Comment;
import model.Favorite;
import model.Person;
import model.User;

public class UserController {
    private static UserController instance;

    static DatabaseHandler conn = new DatabaseHandler();

    public UserController() {

    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public boolean addNewUser(User user) {
        conn.connect();
        String query = "INSERT INTO person VALUES(?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getStatus());

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect(); // Make sure to close the connection in the finally block
        }
    }

    public ArrayList<User> getAllUserList() {
        conn.connect();
        String query = "SELECT * FROM person";
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getString("status"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<Person> getUserComment(int chapter_id) {
        conn.connect();
        String query = "SELECT person.username FROM person JOIN comment ON person.id = comment.id WHERE comment.chapter_id = " + chapter_id;
        ArrayList<Person> users = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Person user = new Person();
                user.setUsername(resultSet.getString("username"));
                
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean addComment(Comment comment, int id, int chapter_id) {
        conn.connect();
        String query = "INSERT INTO comment VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, comment.getComment_id());
            statement.setInt(2, id);
            statement.setInt(3, chapter_id);
            statement.setString(4, comment.getComment_content());

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect(); // Make sure to close the connection in the finally block
        }
    }

    public boolean addFavorite(Favorite favorite, int id, int book_id) {
        conn.connect();
        String query = "INSERT INTO favorite VALUES(?,?,?)";
        try {
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, favorite.getFavorite_id());
            statement.setInt(2, id);
            statement.setInt(3, book_id);

            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect(); // Make sure to close the connection in the finally block
        }
    }
}
