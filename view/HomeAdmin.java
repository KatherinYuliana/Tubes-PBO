package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Account;
import controller.BookController;
import model.Book;
import model.User;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class HomeAdmin {
    // private Connection connection;
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    BookController con = BookController.getInstance();
    private Connection connection;
    private JTextField titleField, authorField, yearField, genreField, ratingField;
    private JTextArea synopsisArea;
    private JRadioButton novelButton, comicButton;
    private JComboBox<String> statusComboBox;
    private JLabel coverLabel, fileNameLabel;
    private File selectedFile;
    private String filePath;

    private JLabel[] imageLabels;

    private static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public HomeAdmin() {
        frame = new JFrame("Menu Admin");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);

        // Logout button
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(700, 10, 80, 30);
        frame.add(logoutButton);

        // Menu Admin
        JLabel menuLabel = new JLabel("Menu Admin");
        menuLabel.setBounds(10, 10, 200, 30);
        menuLabel.setFont(new Font("Serif", Font.BOLD, 30));
        frame.add(menuLabel);

        // Table
        // tableModel = new DefaultTableModel();
        // table = new JTable(tableModel);
        // tableModel.addColumn("ID");
        // tableModel.addColumn("Cover Buku");
        // tableModel.addColumn("Judul Buku");
        // tableModel.addColumn("Edit Buku");
        // tableModel.addColumn("Hapus Buku");
        ArrayList<Book> showAllBook = con.getAllBookAdmin();
        String[] columnNames = { "ID", "Judul Buku", "Author", "Category" };

        Object[][] data = new Object[showAllBook.size()][4];

        for (int i = 0; i < showAllBook.size(); i++) {
            Book book = showAllBook.get(i);
            data[i][0] = book.getBook_id();
            data[i][1] = book.getBook_title();
            data[i][2] = book.getAuthor();
            data[i][3] = book.getCategory();

        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable userTable = new JTable(model);

        // Add book button
        JButton addButton = new JButton("Tambah Buku");
        addButton.setBounds(10, 280, 120, 30);
        frame.add(addButton);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookForm();
            }
        });

        // Add book button
        JButton editButton = new JButton("Edit Buku");
        editButton.setBounds(150, 280, 120, 30);
        frame.add(editButton);

        // Add action listeners
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel editLabel = new JLabel("Masukkan id buku yang mau di edit:");
                editLabel.setBounds(10, 330, 250, 25);
                frame.add(editLabel);

                JTextField editField = new JTextField(15);
                editField.setBounds(10, 360, 165, 25);
                frame.add(editField);

                JButton cariButton = new JButton("Cari");
                cariButton.setBounds(10, 390, 70, 20);
                frame.add(cariButton);
                frame.revalidate();
                frame.repaint();

                editButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame = new JFrame("Edit Book");
                        frame.setSize(800, 600);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.setLayout(null);

                        // Tambah Buku
                        JLabel menuLabel = new JLabel("Edit Buku");
                        menuLabel.setBounds(10, 10, 200, 30);
                        menuLabel.setFont(new Font("Serif", Font.BOLD, 20));
                        frame.add(menuLabel);

                        // Judul Buku
                        JLabel titleLabel = new JLabel("Judul Buku:");
                        titleLabel.setBounds(10, 50, 150, 25);
                        frame.add(titleLabel);
                        titleField = new JTextField();
                        titleField.setBounds(170, 50, 300, 25);
                        frame.add(titleField);

                        // Author
                        JLabel authorLabel = new JLabel("Author:");
                        authorLabel.setBounds(10, 90, 150, 25);
                        frame.add(authorLabel);
                        authorField = new JTextField();
                        authorField.setBounds(170, 90, 300, 25);
                        frame.add(authorField);

                        // Tahun Terbit
                        JLabel yearLabel = new JLabel("Tahun Terbit:");
                        yearLabel.setBounds(10, 130, 150, 25);
                        frame.add(yearLabel);
                        yearField = new JTextField();
                        yearField.setBounds(170, 130, 300, 25);
                        frame.add(yearField);

                        // Genre
                        JLabel genreLabel = new JLabel("Genre:");
                        genreLabel.setBounds(10, 170, 150, 25);
                        frame.add(genreLabel);
                        genreField = new JTextField();
                        genreField.setBounds(170, 170, 300, 25);
                        frame.add(genreField);

                        // Kategori
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

                        // Rating
                        JLabel ratingLabel = new JLabel("Rating:");
                        ratingLabel.setBounds(10, 250, 150, 25);
                        frame.add(ratingLabel);
                        ratingField = new JTextField();
                        ratingField.setBounds(170, 250, 300, 25);
                        frame.add(ratingField);

                        // Sinopsis
                        JLabel synopsisLabel = new JLabel("Sinopsis:");
                        synopsisLabel.setBounds(10, 290, 150, 25);
                        frame.add(synopsisLabel);
                        synopsisArea = new JTextArea();
                        synopsisArea.setBounds(170, 290, 300, 100);
                        frame.add(synopsisArea);

                        // Status
                        JLabel statusLabel = new JLabel("Status Buku:");
                        statusLabel.setBounds(10, 430, 150, 25);
                        frame.add(statusLabel);
                        String[] statuses = { "Ongoing", "Completed", "Hiatus" };
                        statusComboBox = new JComboBox<>(statuses);
                        statusComboBox.setBounds(170, 430, 300, 25);
                        frame.add(statusComboBox);

                        // Cover Buku
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
                                JFileChooser fileChooser = new JFileChooser(
                                        "D:Documents/Kuliah/Semester pendek/PBO/Tubes - copy/pictures");
                                int option = fileChooser.showOpenDialog(frame);
                                if (option == JFileChooser.APPROVE_OPTION) {
                                    selectedFile = fileChooser.getSelectedFile();
                                    fileNameLabel.setText(selectedFile.getName());
                                    filePath = selectedFile.getAbsolutePath();
                                }
                            }
                        });

                        // Submit
                        JButton submitButton = new JButton("Edit");
                        submitButton.setBounds(170, 510, 150, 25);
                        frame.add(submitButton);
                        // Logic for logging out
                        // new MenuUtama();
                        // frame.dispose();
                    }
                });
            }
        });

        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(10, 60, 760, 200);
        frame.add(scrollPane);

        // Log Out Buton
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for logging out
                new MenuAwal();
                frame.dispose();
            }
        });
        
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new HomeAdmin();
    }
}
