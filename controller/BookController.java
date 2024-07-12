package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Book;
import model.Chapter;
import model.Comment;

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

    // menambah buku baru (admin)
    public boolean addNewBook(Book book) {
        conn.connect();
        String query = "INSERT INTO book VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, book.getBook_id());
            statement.setString(2, book.getBook_title());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getPublication_year());
            statement.setString(5, book.getGenre());
            statement.setString(6, book.getCategory());
            statement.setDouble(7, book.getRating());
            statement.setString(8, book.getSinopsis());
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

    // mengambil semua list buku
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
                book.setGenre(resultSet.getString("genre"));
                book.setCategory(resultSet.getString("category"));
                book.setRating(resultSet.getDouble("rating"));
                book.setSinopsis(resultSet.getString("sinopsis"));
                book.setBook_status(resultSet.getString("book_status"));
                book.setBook_cover(resultSet.getString("book_cover"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // menampilkan semua list buku untuk admin
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

    // menampilkan informasi buku
    public ArrayList<Book> getBookInfo(int book_id, String book_title) {
        conn.connect();
        String query = "SELECT * FROM book WHERE book_id = " + book_id + " OR book_title = '" + book_title + "'";
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
                book.setGenre(resultSet.getString("genre"));
                book.setCategory(resultSet.getString("category"));
                book.setRating(resultSet.getDouble("rating"));
                book.setSinopsis(resultSet.getString("sinopsis"));
                book.setBook_status(resultSet.getString("book_status"));
                book.setBook_cover(resultSet.getString("book_cover"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // mengedit informasi buku (admin)
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

    // menghapus buku (admin)
    public boolean deleteBook(int book_id) {
        try {
            String query = "DELETE FROM book WHERE book_id = ?";
            PreparedStatement statement = conn.con.prepareStatement(query);
            statement.setInt(1, book_id);

            // Execute the SQL statement and check if the deletion was successful
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.disconnect();
        }
    }

    // menampilkan list favorit
    public ArrayList<Book> getFavoriteList(int user_id) {
        conn.connect();
        String query = "SELECT b.book_cover, b.book_title FROM favorite f JOIN book b ON f.book_id = b.book_id WHERE f.id = "
                + user_id;
        ArrayList<Book> books = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Book book = new Book();
                book.setBook_cover(resultSet.getString("book_cover"));
                book.setBook_title(resultSet.getString("book_title"));

                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public boolean cekFavoriteList(int book_id) {
        boolean exists = false;
        try {
            String query = "SELECT COUNT(*) FROM favorite WHERE book_id = " + book_id;
            PreparedStatement preparedStatement = conn.con.prepareStatement(query);
            preparedStatement.setInt(1, book_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt(book_id) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    // menampilkan komentar
    public ArrayList<Comment> getComment(int chapter_id) {
        conn.connect();
        String query = "SELECT comment_content FROM comment WHERE chapter_id = " + chapter_id;
        ArrayList<Comment> comments = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setComment_content(resultSet.getString("comment_content"));

                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    // menambah chapter baru (admin)
    public boolean addChapter(Chapter chapter, int book_id) {
        conn.connect();
        String query = "INSERT INTO chapter VALUES(?,?,?,?)";
        try {
            PreparedStatement statement = conn.con.prepareStatement(query);

            statement.setInt(1, chapter.getChapter_id());
            statement.setInt(2, book_id);
            statement.setString(3, chapter.getChapter_title());
            statement.setString(4, chapter.getChapter_content());

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

    // menampilkan chapter
    public ArrayList<Chapter> getChapter(int book_id) {
        conn.connect();
        String query = "SELECT chapter_id, chapter_title, chapter_content FROM chapter WHERE book_id = " + book_id;
        ArrayList<Chapter> chapters = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Chapter chapter = new Chapter();
                chapter.setChapter_id(resultSet.getInt("chapter_id"));
                chapter.setChapter_title(resultSet.getString("chapter_title"));
                chapter.setChapter_content(resultSet.getString("chapter_content"));

                chapters.add(chapter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chapters;
    }

    // menampilkan isi chapter
    public ArrayList<Chapter> getChapterContent(int book_id, int chapter_id) {
        conn.connect();
        String query = "SELECT chapter_title, chapter_content FROM chapter WHERE book_id = " + book_id
                + " AND chapter_id = " + chapter_id;
        ArrayList<Chapter> chapters = new ArrayList<>();
        try {
            Statement statement = conn.con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Chapter chapter = new Chapter();
                chapter.setChapter_title(resultSet.getString("chapter_title"));
                chapter.setChapter_content(resultSet.getString("chapter_content"));

                chapters.add(chapter);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chapters;
    }
}
