package view;

import controller.BookController;
import model.Chapter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ChapterScreen {
    BookController con = BookController.getInstance();

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

    public ChapterScreen(int book_id, int user_id, int chapter_id) {
        JFrame frame = new JFrame("Chapter Screen");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 25);
        frame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BookInfoScreen(book_id, user_id, "");
                frame.dispose();
            }
        });

        ArrayList<Chapter> showChapter = con.getChapterContent(book_id, chapter_id);
        for (int i = 0; i < showChapter.size(); i++) {
            Chapter chapter = showChapter.get(i);

            String judul_chapter = chapter.getChapter_title();
            JLabel chapter_titleLabel = new JLabel(judul_chapter);
            chapter_titleLabel.setBounds(100, 8, 200, 30);
            chapter_titleLabel.setFont(new Font("Serif", Font.BOLD, 25));
            frame.add(chapter_titleLabel);

            String isi_chapter = chapter.getChapter_content();
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
            loadFileContent(isi_chapter, textArea);
        }

        // Lihat komentar button
        JButton lihatKomentarButton = new JButton("Lihat Komentar");
        lihatKomentarButton.setBounds(100, 520, 140, 30);
        frame.add(lihatKomentarButton);

        lihatKomentarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CommentScreen(user_id, chapter_id);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    // int book_id = 1;
    // int id = 2;
    // int chapter_id = 1;
    // new ChapterScreen(book_id, id, chapter_id);
    // }
}
