package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ChapterScreen {

    private void loadFileContent(String filePath, JTextArea textArea) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
        }
    }

    public ChapterScreen() {
        JFrame frame = new JFrame("Chapter Screen");
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
                int id = 4;
                new BookInfoScreen(id);
            }
        });

        // Panel in the center
        // Color color = new Color(255, 255, 255);
        // JPanel panel = new JPanel();
        // panel.setBounds(100, 50, 580, 460);
        // panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        // panel.setBackground(color);
        // frame.add(panel);

        JPanel panel = new JPanel();
        panel.setBounds(100, 40, 580, 470);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        // Text area to display file content
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane);

        // Load file content into text area
        loadFileContent("teks.txt", textArea);

        // Lihat komentar button
        JButton lihatKomentarButton = new JButton("Lihat Komentar");
        lihatKomentarButton.setBounds(100, 520, 140, 30);
        frame.add(lihatKomentarButton);

        lihatKomentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        new ChapterScreen();
    }
}
