package view;

// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// public class FavoriteScreen {
//     public FavoriteScreen() {
//         JFrame frame = new JFrame("Jadwal");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(800, 600);
//         frame.setLayout(null);

//         JPanel panel = new JPanel();
//         panel.setLayout(null);
//         panel.setBounds(0, 0, 800, 600);

//         // Home button
//         JButton homeButton = new JButton("Home");
//         homeButton.setBounds(10, 10, 80, 30);
//         panel.add(homeButton);

//         homeButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 new HomeUser();
//                 frame.setVisible(false);
//             }
//         });

//         // Jadwal button
//         JButton jadwalButton = new JButton("Jadwal");
//         jadwalButton.setBounds(100, 10, 80, 30);
//         panel.add(jadwalButton);

//         jadwalButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 new ScheduleScreen();
//                 frame.setVisible(false);
//             }
//         });

//         // Favorit button
//         JButton favoritButton = new JButton("Favorit");
//         favoritButton.setBounds(190, 10, 80, 30);
//         panel.add(favoritButton);

//         favoritButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 new FavoriteScreen();
//                 frame.setVisible(false);
//             }
//         });

//         // Log out button
//         JButton logoutButton = new JButton("Log out");
//         logoutButton.setBounds(700, 10, 80, 30);
//         panel.add(logoutButton);
        
//         logoutButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 new MenuAwal();
//                 frame.setVisible(false);
//             }
//         });

//         frame.add(panel);
//         frame.setLocationRelativeTo(null);
//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         new FavoriteScreen();
//     }
// }

import javax.swing.*;

import controller.BookController;
import model.Book;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FavoriteScreen {
    private JFrame frame;
    private JPanel favoritePanel;
    BookController con = BookController.getInstance();

    public FavoriteScreen(int id) {
        frame = new JFrame("Favorite Screen");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Home button
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(10, 10, 80, 30);
        frame.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeUser(id);
                frame.setVisible(false);
            }
        });

        // Jadwal button
        JButton jadwalButton = new JButton("Jadwal");
        jadwalButton.setBounds(100, 10, 80, 30);
        frame.add(jadwalButton);

        jadwalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int book_id = 2;
                new ScheduleScreen(book_id, id);
                frame.setVisible(false);
            }
        });

        // Favorit button
        JButton favoritButton = new JButton("Favorit");
        favoritButton.setBounds(190, 10, 80, 30);
        frame.add(favoritButton);

        favoritButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FavoriteScreen(id);
                frame.dispose();
                //frame.setVisible(false);
            }
        });

        // Log out button
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(700, 10, 80, 30);
        frame.add(logoutButton);
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAwal();
                frame.dispose();
                //frame.setVisible(false);
            }
        });

        // Title label
        JLabel titleLabel = new JLabel("Daftar Favorit");
        titleLabel.setBounds(10, 50, 200, 30);
        frame.add(titleLabel);

        // Panel for favorite books
        favoritePanel = new JPanel();
        // favoritePanel.setBounds(10, 80, 760, 460);
        // frame.add(titleLabel);

        favoritePanel.setLayout(new BoxLayout(favoritePanel, BoxLayout.Y_AXIS));

        // Scroll pane for favorite books
        JScrollPane scrollPane = new JScrollPane(favoritePanel);
        scrollPane.setBounds(10, 90, 760, 250);
        frame.add(scrollPane);

        // Fetch and display favorite books
        fetchAndDisplayFavorites(id);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void fetchAndDisplayFavorites(int id) {
        ArrayList<Book> showFavoriteBook = con.getFavoriteList(id);
        //List<Book> favoriteBooks = getFavoriteBooksFromDatabase(id);

        if (showFavoriteBook.isEmpty()) {
            JLabel emptyLabel = new JLabel("Daftar List Kosong");
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            emptyLabel.setVerticalAlignment(SwingConstants.CENTER);
            emptyLabel.setBounds(0, 0, 760, 460);
            favoritePanel.add(emptyLabel);
        } else {
            for (Book book : showFavoriteBook) {
                JPanel bookPanel = new JPanel();
                bookPanel.setLayout(null); // Use null layout
                bookPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                bookPanel.setBounds(10, 50, 740, 60); // Set bounds for book panel
            
                String cover = book.getBook_cover();
                JLabel bookCover = new JLabel(scaleImage(cover, 80, 100));
                bookCover.setBounds(10, 10, 80, 100); // Set bounds for book cover
                bookPanel.add(bookCover);
            
                JLabel titleLabel = new JLabel(book.getBook_title());
                titleLabel.setFont(new Font("Serif", Font.BOLD, 16));
                titleLabel.setBounds(100, 40, 600, 30); // Set bounds for title label
                bookPanel.add(titleLabel);
            
                favoritePanel.add(bookPanel);
            }
            
            // for (Book book : showFavoriteBook) {
            //     JPanel bookPanel = new JPanel();
            //     bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.X_AXIS));
            //     bookPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            //     bookPanel.setBounds(10, 50, 740, 100);
            //     //bookPanel.setPreferredSize(new Dimension(740, 100));

            //     String cover = book.getBook_cover();
            //     JLabel bookCover = new JLabel(scaleImage(cover, 80, 100));
            //     // bookCover.setBounds(50, 70, 150, 200);
            //     // frame.add(bookCover);

            //     // JLabel coverLabel = new JLabel(new ImageIcon(book.getBook_cover()));
            //     bookCover.setPreferredSize(new Dimension(180, 300));
            //     bookPanel.add(bookCover);

            //     JLabel titleLabel = new JLabel(book.getBook_title());
            //     titleLabel.setFont(new Font("Serif", Font.BOLD, 16));
            //     bookPanel.add(titleLabel);

            //     favoritePanel.add(bookPanel);
            // }
        }

        favoritePanel.revalidate();
        favoritePanel.repaint();
    }

    private static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    // private List<Book> getFavoriteBooksFromDatabase(int userId) {
    //     List<Book> favoriteBooks = new ArrayList<>();

    //     try {
    //         Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
    //         String query = "SELECT book_cover, book_title FROM favorites WHERE user_id = ?";
    //         PreparedStatement statement = connection.prepareStatement(query);
    //         statement.setInt(1, userId);

    //         ResultSet resultSet = statement.executeQuery();
    //         while (resultSet.next()) {
    //             String coverPath = resultSet.getString("book_cover");
    //             String title = resultSet.getString("book_title");
    //             favoriteBooks.add(new Book(coverPath, title));
    //         }

    //         resultSet.close();
    //         statement.close();
    //         connection.close();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    //     return favoriteBooks;
    // }

    public static void main(String[] args) {
        new FavoriteScreen(3); // Pass the user ID as argument
    }

    // class Book {
    //     private String coverPath;
    //     private String title;

    //     public Book(String coverPath, String title) {
    //         this.coverPath = coverPath;
    //         this.title = title;
    //     }

    //     public String getCoverPath() {
    //         return coverPath;
    //     }

    //     public String getTitle() {
    //         return title;
    //     }
    // }
}
