package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookInfoScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Book Info");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 30);
        frame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeUser();
                frame.setVisible(false);
            }
        });

        // Book cover
        JLabel bookCover = new JLabel();
        bookCover.setBounds(50, 70, 150, 200);
        bookCover.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(bookCover);

        // Book title
        JLabel titleLabel = new JLabel("Judul buku");
        titleLabel.setBounds(220, 70, 200, 30);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        frame.add(titleLabel);

        // Author label
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(220, 110, 200, 30);
        frame.add(authorLabel);

        // Publication label
        JLabel yearLabel = new JLabel("Publication Year:");
        yearLabel.setBounds(220, 130, 200, 30);
        frame.add(yearLabel);

        // Genre label
        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(220, 150, 200, 30);
        frame.add(genreLabel);

        // Category label
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(220, 170, 200, 30);
        frame.add(categoryLabel);

        // Add to favorite button
        JButton favoriteButton = new JButton("Tambah Favorit");
        favoriteButton.setBounds(50, 280, 150, 30);
        frame.add(favoriteButton);

        favoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                favoriteButton.setEnabled(false);
            }
        });

        // Chapter 1 button
        JButton chapter1Button = new JButton("Chapter 1");
        chapter1Button.setBounds(50, 320, 700, 40);
        frame.add(chapter1Button);

        // Chapter 2 button
        JButton chapter2Button = new JButton("Chapter 2");
        chapter2Button.setBounds(50, 370, 700, 40);
        frame.add(chapter2Button);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
