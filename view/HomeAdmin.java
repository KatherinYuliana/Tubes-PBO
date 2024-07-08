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
    private JLabel editLabel;
    private JTable table;
    private DefaultTableModel tableModel;
    BookController con = BookController.getInstance();
    private Connection connection;
    private JTextField titleField, authorField, yearField, genreField, ratingField, editField;
    private JTextArea synopsisArea;
    private JRadioButton novelButton, comicButton;
    private JComboBox<String> statusComboBox;
    private JLabel coverLabel, fileNameLabel;
    private JButton cariButton, hapusButton;
    private File selectedFile;
    private String filePath;
    Book book = new Book();

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
        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(10, 60, 760, 200);
        frame.add(scrollPane);

        // Add book button
        JButton addButton = new JButton("Tambah Buku");
        addButton.setBounds(10, 280, 120, 30);
        frame.add(addButton);

        // Add action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookForm();
                frame.dispose();
            }
        });

        // Edit book button
        JButton editButton = new JButton("Edit Buku");
        editButton.setBounds(150, 280, 120, 30);
        frame.add(editButton);

        // Add action listeners
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editLabel != null) {
                    frame.remove(editLabel);
                }
                if (editField != null) {
                    frame.remove(editField);
                }
                if (cariButton != null) {
                    frame.remove(cariButton);
                }

                editLabel = new JLabel("Masukkan id buku yang mau di edit:");
                editLabel.setBounds(10, 330, 250, 25);
                frame.add(editLabel);

                editField = new JTextField(15);
                editField.setBounds(10, 360, 165, 25);
                frame.add(editField);

                cariButton = new JButton("Cari");
                cariButton.setBounds(10, 390, 70, 20);
                frame.add(cariButton);
                frame.revalidate();
                frame.repaint();

                cariButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        int id = Integer.parseInt(editField.getText());
                        //int a = book.getBook_id();
                        //if (id == book.getBook_id()) {
                        new EditBookInfo(id);
                        // } else {
                        //     JOptionPane.showMessageDialog(frame, "ID tidak ada dalam daftar", "Error",JOptionPane.WARNING_MESSAGE);
                        //     new HomeAdmin();

                        //     //new EditBookInfo(id);
                        // }
                        
                    }
                });
            }
        });

        JButton addChapterButton = new JButton("Tambah Chapter");
        addChapterButton.setBounds(290, 280, 140, 30);
        frame.add(addChapterButton);

        // Add action listeners
        addChapterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editLabel != null) {
                    frame.remove(editLabel);
                }
                if (editField != null) {
                    frame.remove(editField);
                }
                if (cariButton != null) {
                    frame.remove(cariButton);
                }

                editLabel = new JLabel("Masukkan id buku:");
                editLabel.setBounds(10, 330, 250, 25);
                frame.add(editLabel);

                editField = new JTextField(15);
                editField.setBounds(10, 360, 165, 25);
                frame.add(editField);

                cariButton = new JButton("Cari");
                cariButton.setBounds(10, 390, 70, 20);
                frame.add(cariButton);
                frame.revalidate();
                frame.repaint();

                cariButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        int id = Integer.parseInt(editField.getText());
                        new EditBook(id);
                    }
                });
            }
        });

        JButton deleteButton = new JButton("Hapus Buku");
        deleteButton.setBounds(450, 280, 120, 30);
        frame.add(deleteButton);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (editLabel != null) {
                    frame.remove(editLabel);
                }
                if (editField != null) {
                    frame.remove(editField);
                }
                if (hapusButton != null) {
                    frame.remove(hapusButton);
                }

                editLabel = new JLabel("Masukkan id buku yang mau di hapus:");
                editLabel.setBounds(10, 330, 250, 25);
                frame.add(editLabel);

                editField = new JTextField(15);
                editField.setBounds(10, 360, 165, 25);
                frame.add(editField);

                hapusButton = new JButton("Hapus");
                hapusButton.setBounds(10, 390, 70, 20);
                frame.add(hapusButton);
                frame.revalidate();
                frame.repaint();

                hapusButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int id = Integer.parseInt(editField.getText());
                        JOptionPane.showConfirmDialog(null, "Apakah mau menghapus buku dengan id: " + id + " ?");
                        //JOptionPane.showMessageDialog(null, "Selamat Datang Admin");
                        
                    }
                });
            }
        });

        // Log Out Buton
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
