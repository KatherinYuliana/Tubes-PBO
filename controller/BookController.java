package controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.Book;
import model.Comment;
import model.Person;
import model.User;
import model.Enum.BookStatusEnum;
import model.Enum.CategoryBookEnum;
import model.Enum.GenreEnum;

public class BookController {
    private static BookController instance;
    static DatabaseHandler conn = new DatabaseHandler();

    public BookController() {
    }

    public static BookController getInstance() {
        if (instance == null) {
            instance = new BookController();
        }
        return instance;
    }

    public boolean addNewBook(Book book) {
        conn.connect();
        String query = "INSERT INTO book VALUES(?,?,?,?,?,?,?,?,?,?)";
        // String query = "INSERT INTO book (book_id, book_title, author,
        // publication_year, genre, category, rating, sinopsis, book_status, book_cover)
        // VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, book.getBook_id());
            statement.setString(2, book.getBook_title());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getPublication_year());
            // statement.setInt(4, book.getPublication_year());
            // statement.setDate(4, new
            // java.sql.Date(book.getPublication_year().getTime())); // Convert
            // java.util.Date to java.sql.Date
            // statement.setString(5, book.getGenre().name()); // Convert enum to string
            statement.setString(5, book.getGenre());
            // statement.setString(6, book.getCategory().name()); // Convert enum to string
            statement.setString(6, book.getCategory());
            statement.setDouble(7, book.getRating());
            statement.setString(8, book.getSinopsis());
            // statement.setString(9, book.getBook_status().name()); // Convert enum to
            // string
            statement.setString(9, book.getBook_status());
            statement.setString(10, book.getBook_cover());

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

    public ArrayList<Book> getAllBookList() {
        conn.connect();
        String query = "SELECT * FROM book";
        ArrayList<Book> books = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Book book = new Book();
                book.setBook_id(resultSet.getInt("book_id"));
                book.setBook_title(resultSet.getString("book_title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublication_year(resultSet.getString("publication_year"));
                // book.setPublication_year(resultSet.getInt("publication_year"));
                // book.setPublication_year(resultSet.getDate("publication_year"));
                // book.setGenre(GenreEnum.valueOf(resultSet.getString("genre")));
                book.setGenre(resultSet.getString("genre"));
                // book.setCategory(CategoryBookEnum.valueOf(resultSet.getString("category")));
                book.setCategory(resultSet.getString("category"));
                book.setRating(resultSet.getDouble("rating"));
                book.setSinopsis(resultSet.getString("sinopsis"));
                // book.setBook_status(BookStatusEnum.valueOf(resultSet.getString("book_status")));
                book.setBook_status(resultSet.getString("book_status"));
                book.setBook_cover(resultSet.getString("book_cover"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public ArrayList<Book> getAllBookAdmin() {
        conn.connect();
        String query = "SELECT book_id, book_title, author, category, book_status FROM book";
        ArrayList<Book> books = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Book book = new Book();
                book.setBook_id(resultSet.getInt("book_id"));
                // book.setBook_cover(resultSet.getString("book_cover"));
                book.setBook_title(resultSet.getString("book_title"));
                book.setAuthor(resultSet.getString("author"));
                book.setCategory(resultSet.getString("category"));
                book.setBook_status(resultSet.getString("book_status"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public ArrayList<Book> getBookInfo(int book_id) {
        conn.connect();
        String query = "SELECT * FROM book WHERE book_id = '" + book_id + "'";
        // String query = "SELECT * FROM book WHERE book_id = '" + id + "'" + " OR
        // book_title = '" + title + "'";
        ArrayList<Book> books = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Book book = new Book();
                book.setBook_id(resultSet.getInt("book_id"));
                book.setBook_title(resultSet.getString("book_title"));
                book.setAuthor(resultSet.getString("author"));
                book.setPublication_year(resultSet.getString("publication_year"));
                // book.setPublication_year(resultSet.getInt("publication_year"));
                // book.setPublication_year(resultSet.getDate("publication_year"));
                // book.setGenre(GenreEnum.valueOf(resultSet.getString("genre")));
                book.setGenre(resultSet.getString("genre"));
                // book.setCategory(CategoryBookEnum.valueOf(resultSet.getString("category")));
                book.setCategory(resultSet.getString("category"));
                book.setRating(resultSet.getDouble("rating"));
                book.setSinopsis(resultSet.getString("sinopsis"));
                // book.setBook_status(BookStatusEnum.valueOf(resultSet.getString("book_status")));
                book.setBook_status(resultSet.getString("book_status"));
                book.setBook_cover(resultSet.getString("book_cover"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public boolean editBookInfo(int book_id, String book_title, String author, String publication_year, String genre,
            String category, Double rating, String sinopsis, String book_status, String book_cover) {
        conn.connect();
        String query = "UPDATE book"
                + " SET book_title='" + book_title + "',"
                + "author='" + author + "',"
                + "publication_year='" + publication_year + "',"
                + "genre='" + genre + "',"
                + "category='" + category + "',"
                + "rating='" + rating + "',"
                + "sinopsis='" + sinopsis + "',"
                + "book_status='" + book_status + "',"
                + "book_cover='" + book_cover
                + "' WHERE book_id = " + book_id;
        PreparedStatement stmt;
        try {
            stmt = conn.con.prepareStatement(query);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(int book_id) {
        try {
            String query = "DELETE FROM book WHERE id = ?";
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, book_id);
            statement.executeUpdate();

            // // Refresh the table data
            // tableModel.setRowCount(0);
            // loadData();
            // Check if the insertion was successful
            // Execute the SQL statement
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

    public ArrayList<Book> getFavoriteList(int id) {
        conn.connect();
        String query = "SELECT b.book_cover, b.book_title FROM favorite f JOIN book b ON f.book_id = b.book_id WHERE f.id = " + id;
        ArrayList<Book> books = new ArrayList<>();
        // PreparedStatement statement = connection.prepareStatement(query);
        // statement.setInt(1, userId);
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Book book = new Book();
                //book.setBook_id(resultSet.getInt("book_id"));
                book.setBook_cover(resultSet.getString("book_cover"));
                book.setBook_title(resultSet.getString("book_title"));
                // book.setAuthor(resultSet.getString("author"));
                // book.setCategory(resultSet.getString("category"));
                // book.setBook_status(resultSet.getString("book_status"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // public ArrayList<Person> getComment(int chapter_id) {
    //     conn.connect();
    //     //String query = "SELECT person.username, comment.comment_content FROM person JOIN comment ON person.id = comment.id";
    //     String query = "SELECT person.username, comment.comment_content FROM person JOIN comment ON person.id = comment.id WHERE comment.chapter_id = " + chapter_id;
    //     ArrayList<Person> coment = new ArrayList<>();
    //     // PreparedStatement statement = connection.prepareStatement(query);
    //     // statement.setInt(1, userId);
    //     try {
    //         Statement statement = conn.con.createStatement();
    //         ResultSet resultSet = statement.executeQuery(query);
    //         while (resultSet.next()) {
    //             Person person = new Person();
    //             Comment comment = new Comment();
    //             person.setUsername(resultSet.getString("username"));
    //             comment.setComment_content(resultSet.getString("comment_content"));
    //             //Book book = new Book();
    //             //book.setBook_id(resultSet.getInt("book_id"));
    //             // book.setBook_cover(resultSet.getString("book_cover"));
    //             // book.setBook_title(resultSet.getString("book_title"));
    //             // book.setAuthor(resultSet.getString("author"));
    //             // book.setCategory(resultSet.getString("category"));
    //             // book.setBook_status(resultSet.getString("book_status"));

    //             coment.add(person);
    //             coment.add(comment);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return books;
    // }
}
