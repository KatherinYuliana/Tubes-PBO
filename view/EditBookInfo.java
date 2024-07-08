package view;

import javax.print.DocFlavor.STRING;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.swing.*;

import controller.BookController;
import model.Book;
import model.User;
import model.Enum.CategoryBookEnum;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.*;
import java.util.ArrayList;

public class EditBookInfo {
    private Connection connection;
    private JFrame frame;
    private JTextField titleField, authorField, yearField, genreField, ratingField;
    private JTextArea synopsisArea;
    private JRadioButton novelButton, comicButton;
    private JComboBox<String> statusComboBox;
    private JLabel coverLabel, fileNameLabel;
    private File selectedFile;
    private String filePath;

    BookController con = BookController.getInstance();

    public EditBookInfo(int id) {
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
        

        // Author
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 90, 150, 25);
        frame.add(authorLabel);
        

        // Tahun Terbit
        JLabel yearLabel = new JLabel("Tahun Terbit:");
        yearLabel.setBounds(10, 130, 150, 25);
        frame.add(yearLabel);
        

        // Genre
        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(10, 170, 150, 25);
        frame.add(genreLabel);
        

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
        

        // Sinopsis
        JLabel synopsisLabel = new JLabel("Sinopsis:");
        synopsisLabel.setBounds(10, 290, 150, 25);
        frame.add(synopsisLabel);
        

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
                        "D:Documents/Kuliah/Semester pendek/PBO/Tubes/pictures");
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    fileNameLabel.setText(selectedFile.getName());
                    filePath = selectedFile.getAbsolutePath();
                }
            }
        });

        ArrayList<Book> showAllBook = con.getBookInfo(id);

        //Object[][] data = new Object[showAllBook.size()][4];

        for (int i = 0; i < showAllBook.size(); i++) {
            Book book = showAllBook.get(i);

            // String cover = book.getBook_cover();
            // JLabel bookCover2 = new JLabel(scaleImage(cover, 150, 200));
            // bookCover2.setBounds(50, 70, 150, 200);
            // frame.add(bookCover2);

            String judul = book.getBook_title();
            // JLabel titleLabel = new JLabel(judul);
            // titleLabel.setBounds(220, 70, 500, 30);
            // titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
            // frame.add(titleLabel);
            titleField = new JTextField(judul);
            titleField.setBounds(170, 50, 300, 25);
            frame.add(titleField);

            String author = book.getAuthor();
            authorField = new JTextField(author);
            authorField.setBounds(170, 90, 300, 25);
            frame.add(authorField);
            // JLabel authorLabel2 = new JLabel(author);
            // authorLabel2.setBounds(265, 110, 200, 30);
            // frame.add(authorLabel2);

            String tahun = book.getPublication_year().toString();
            yearField = new JTextField(tahun);
            yearField.setBounds(170, 130, 300, 25);
            frame.add(yearField);
            // JLabel yearLabel2 = new JLabel(tahun);
            // yearLabel2.setBounds(320, 130, 200, 30);
            // frame.add(yearLabel2);

            String genre = book.getGenre();
            genreField = new JTextField(genre);
            genreField.setBounds(170, 170, 300, 25);
            frame.add(genreField);
            // JLabel genreLabel2 = new JLabel(genre);
            // genreLabel2.setBounds(265, 150, 200, 30);
            // frame.add(genreLabel2);

           
            String kategori = book.getCategory();
            // if (kategori == "Novel") {
            //     CategoryBookEnum cat = CategoryBookEnum.NOVEL;
            //     kategori = cat;
            // }
            if (kategori.equals("Novel")) {
                novelButton.setSelected(true);
            } else if (kategori.equals("Komik")) {
                comicButton.setSelected(true);
            }
            // JLabel categoryLabel2 = new JLabel(kategori);
            // categoryLabel2.setBounds(280, 170, 200, 30);
            // frame.add(categoryLabel2);

            //Double rating = book.getRating();
            String rating = String.valueOf(book.getRating());
            ratingField = new JTextField(rating);
            ratingField.setBounds(170, 250, 300, 25);
            frame.add(ratingField);
            // JLabel ratingLabel2 = new JLabel(rating);
            // ratingLabel2.setBounds(265, 190, 200, 30);
            // frame.add(ratingLabel2);

            String status = book.getBook_status();
            // JLabel statusLabel2 = new JLabel(status);
            // statusLabel2.setBounds(265, 210, 200, 30);
            // frame.add(statusLabel2);
            //String status = user.getStatus_perkawinan();
            statusComboBox.setSelectedItem(status);

            String sinopsis = book.getSinopsis();
            synopsisArea = new JTextArea(sinopsis);
            synopsisArea.setBounds(170, 290, 300, 100);
            frame.add(synopsisArea);

            String cover = book.getBook_cover();
            fileNameLabel = new JLabel(cover);
            fileNameLabel.setBounds(330, 470, 240, 25);
            frame.add(fileNameLabel);
            // JLabel sinopsisLabel2 = new JLabel(sinopsis);
            // sinopsisLabel2.setBounds(275, 230, 200, 30);
            // frame.add(sinopsisLabel2);
            // JLabel bookCover2 = new JLabel(cover);
            // bookCover2.setBounds(50, 70, 150, 200);
            // //bookCover2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // frame.add(bookCover2);

            // data[i][0] = book.getBook_id();
            // data[i][1] = book.getBook_title();
            // data[i][2] = book.getAuthor();
            // data[i][3] = book.getCategory();
        }

        // Submit
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(170, 510, 150, 25);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // String book_title = titleField.getText();
                // String author = authorField.getText();
                // String year = yearField.getText();
                // //int year = Integer.parseInt(yearField.getText());
                // String genre = genreField.getText();
                // String category = novelButton.isSelected() ? "Novel" : "Comic";
                // double rating = Double.parseDouble(ratingField.getText());
                // String sinopsis = synopsisArea.getText();
                // String book_status = (String) statusComboBox.getSelectedItem();
                // String book_cover = filePath;

                // Blob book_cover = selectedFile.getAbsolutePath();
                // byte[] fileContent = Files.readAllBytes(selectedFile.toPath());
                // Blob book_cover = new SerialBlob(fileContent);
                // File selectedFile = new File("path/to/your/book_cover.jpg");
                // FileInputStream fileInputStream = new FileInputStream(selectedFile);
                // Blob book_cover = connection.createBlob();
                // book_cover.setBinaryStream(1, fileInputStream, (int) selectedFile.length());

                // ArrayList<Book> listBook = con.getAllBookList();
                // Book newBook = new Book(0, book_title, author, year, genre, category, rating, sinopsis, book_status,
                //         book_cover, listBook.size() + 1);
                // boolean cek = con.addNewBook(newBook);
                // if (cek) {
                //     JOptionPane.showMessageDialog(frame, "Buku Berhasil Ditambah", "Success",
                //             JOptionPane.WARNING_MESSAGE);
                //     new HomeAdmin();
                //     frame.dispose();
                // } else {
                //     JOptionPane.showMessageDialog(frame, "Buku Gagal Ditambah", "Error",
                //             JOptionPane.WARNING_MESSAGE);
                // }
            }
        });

        // Log out button
        JButton backButton = new JButton("Back");
        backButton.setBounds(700, 10, 80, 30);
        frame.add(backButton);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeAdmin();
                frame.setVisible(false);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        int id = 1;
        new EditBookInfo(id);
    }
}
