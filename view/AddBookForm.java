package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddBookForm {
    private JFrame frame;
    private JTextField titleField, authorField, yearField, genreField, ratingField;
    private JTextArea synopsisArea;
    private JRadioButton novelButton, comicButton;
    private JComboBox<String> statusComboBox;
    private JLabel fileNameLabel;
    private File selectedFile;

    public AddBookForm() {
        frame = new JFrame("Add Book");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        // Tambah Buku
        JLabel menuLabel = new JLabel("Tambah Buku");
        menuLabel.setBounds(10, 10, 200, 30);
        menuLabel.setFont(new Font("Serif", Font.BOLD, 20));
        frame.add(menuLabel);

        JLabel titleLabel = new JLabel("Judul Buku:");
        titleLabel.setBounds(10, 50, 150, 25);
        frame.add(titleLabel);

        titleField = new JTextField();
        titleField.setBounds(170, 50, 300, 25);
        frame.add(titleField);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 90, 150, 25);
        frame.add(authorLabel);

        authorField = new JTextField();
        authorField.setBounds(170, 90, 300, 25);
        frame.add(authorField);

        JLabel yearLabel = new JLabel("Tahun Terbit:");
        yearLabel.setBounds(10, 130, 150, 25);
        frame.add(yearLabel);

        yearField = new JTextField();
        yearField.setBounds(170, 130, 300, 25);
        frame.add(yearField);

        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(10, 170, 150, 25);
        frame.add(genreLabel);

        genreField = new JTextField();
        genreField.setBounds(170, 170, 300, 25);
        frame.add(genreField);

        JLabel categoryLabel = new JLabel("Kategori:");
        categoryLabel.setBounds(10, 210, 150, 25);
        frame.add(categoryLabel);

        novelButton = new JRadioButton("Novel");
        novelButton.setBounds(170, 210, 100, 25);
        frame.add(novelButton);

        comicButton = new JRadioButton("Komik");
        comicButton.setBounds(280, 210, 150, 25);
        frame.add(comicButton);

        ButtonGroup categoryGroup = new ButtonGroup();
        categoryGroup.add(novelButton);
        categoryGroup.add(comicButton);

        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(10, 250, 150, 25);
        frame.add(ratingLabel);

        ratingField = new JTextField();
        ratingField.setBounds(170, 250, 300, 25);
        frame.add(ratingField);

        JLabel synopsisLabel = new JLabel("Sinopsis:");
        synopsisLabel.setBounds(10, 290, 150, 25);
        frame.add(synopsisLabel);

        synopsisArea = new JTextArea();
        synopsisArea.setBounds(170, 290, 300, 100);
        frame.add(synopsisArea);

        JLabel statusLabel = new JLabel("Status Buku:");
        statusLabel.setBounds(10, 430, 150, 25);
        frame.add(statusLabel);

        String[] statuses = { "Ongoing", "Completed", "Hiatus" };
        statusComboBox = new JComboBox<>(statuses);
        statusComboBox.setBounds(170, 430, 300, 25);
        frame.add(statusComboBox);

        JLabel coverLabel = new JLabel("Cover Buku:");
        coverLabel.setBounds(10, 470, 150, 25);
        frame.add(coverLabel);

        JButton chooseFileButton = new JButton("Pilih File");
        chooseFileButton.setBounds(170, 470, 150, 25);
        frame.add(chooseFileButton);

        fileNameLabel = new JLabel("");
        fileNameLabel.setBounds(330, 470, 240, 25);
        frame.add(fileNameLabel);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    fileNameLabel.setText(selectedFile.getName());
                }
            }
        });

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(170, 510, 150, 25);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new AddBookForm();
    }
}
