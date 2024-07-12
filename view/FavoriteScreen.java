package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import controller.BookController;
import model.Book;
import java.awt.*;
import java.util.ArrayList;

public class FavoriteScreen {
    private JFrame frame;
    private JPanel favoritePanel;
    BookController con = BookController.getInstance();

    private static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public FavoriteScreen(int user_id) {
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
                new HomeUser(user_id);
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
                new ScheduleScreen(book_id, user_id);
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
                new FavoriteScreen(user_id);
                frame.dispose();
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
            }
        });

        // Title label
        JLabel titleLabel = new JLabel("Daftar Favorit");
        titleLabel.setBounds(10, 50, 200, 30);
        frame.add(titleLabel);

        // Panel for favorite books
        favoritePanel = new JPanel();
        favoritePanel.setLayout(new BoxLayout(favoritePanel, BoxLayout.Y_AXIS));

        // Scroll pane for favorite books
        JScrollPane scrollPane = new JScrollPane(favoritePanel);
        scrollPane.setBounds(10, 90, 760, 360);
        frame.add(scrollPane);

        // Fetch and display favorite books
        fetchAndDisplayFavorites(user_id);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void fetchAndDisplayFavorites(int user_id) {
        ArrayList<Book> showFavoriteBook = con.getFavoriteList(user_id);

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
        }

        favoritePanel.revalidate();
        favoritePanel.repaint();
    }

    // public static void main(String[] args) {
    // new FavoriteScreen(5);
    // }
}
