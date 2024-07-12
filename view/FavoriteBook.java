package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class FavoriteBook {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/tubes_pbo";
    private static final String USER = "root";
    private static final String PASS = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("Favorite Book");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton favoriteButton = new JButton("Tambah Favorit");
        favoriteButton.setBounds(50, 280, 150, 30);
        frame.add(favoriteButton);

        favoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookId = "someBookId"; // Replace with actual book ID
                if (isBookInFavorites(bookId)) {
                    favoriteButton.setEnabled(false);
                    JOptionPane.showMessageDialog(frame, "Buku sudah ada di daftar favorit");
                } else {
                    if (addBookToFavorites(bookId)) {
                        JOptionPane.showMessageDialog(frame, "Buku ditambahkan ke favorit");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Gagal menambahkan buku ke favorit");
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    private static boolean isBookInFavorites(String bookId) {
        boolean exists = false;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String query = "SELECT COUNT(*) FROM favorite WHERE book_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }

    private static boolean addBookToFavorites(String bookId) {
        boolean success = false;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Check if book exists in person table to satisfy foreign key constraint
            String checkPersonQuery = "SELECT COUNT(*) FROM person WHERE id = ?";
            PreparedStatement checkPersonStmt = connection.prepareStatement(checkPersonQuery);
            checkPersonStmt.setString(1, bookId);
            ResultSet personResultSet = checkPersonStmt.executeQuery();
            if (personResultSet.next() && personResultSet.getInt(1) > 0) {
                String query = "INSERT INTO favorite (book_id) VALUES (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, bookId);
                preparedStatement.executeUpdate();
                success = true;
            } else {
                System.out.println("Foreign key constraint failed: Book ID not found in person table");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
