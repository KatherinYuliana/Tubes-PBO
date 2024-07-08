package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChapterScreen {
    public ChapterScreen() {
        JFrame frame = new JFrame("Chapter Screen");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 30);
        frame.add(backButton);

        // Panel in the center
        Color color = new Color(255, 255, 255);
        JPanel panel = new JPanel();
        panel.setBounds(100, 50, 580, 460);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setBackground(color);
        frame.add(panel);

        // Lihat komentar button
        JButton lihatKomentarButton = new JButton("Lihat Komentar");
        lihatKomentarButton.setBounds(100, 520, 140, 30);
        frame.add(lihatKomentarButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ChapterScreen();
    }
}
