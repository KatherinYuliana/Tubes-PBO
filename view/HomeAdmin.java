package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.BookController;
import model.Book;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeAdmin {
    private JFrame frame;
    private JLabel editLabel, tambahLabel, hapusLabel;
    private JTextField editField, tambahField, hapusField;
    private JButton editButton2, tambahButton, hapusButton;
    BookController con = BookController.getInstance();
    Book book = new Book();

    public HomeAdmin(int admin_id) {
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

        ArrayList<Book> showAllBook = con.getAllBookAdmin();
        String[] columnNames = { "ID", "Judul Buku", "Author", "Category", "Status" };

        Object[][] data = new Object[showAllBook.size()][5];

        for (int i = 0; i < showAllBook.size(); i++) {
            Book book = showAllBook.get(i);
            data[i][0] = book.getBook_id();
            data[i][1] = book.getBook_title();
            data[i][2] = book.getAuthor();
            data[i][3] = book.getCategory();
            data[i][4] = book.getBook_status();
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
                new AddBookForm(admin_id);
                frame.dispose();
            }
        });

        // Edit book button
        JButton editButton = new JButton("Edit Buku");
        editButton.setBounds(150, 280, 120, 30);
        frame.add(editButton);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeOldComponents();

                editLabel = new JLabel("Masukkan id buku yang mau di edit:");
                editLabel.setBounds(10, 330, 250, 25);
                frame.add(editLabel);

                editField = new JTextField(15);
                editField.setBounds(10, 360, 165, 25);
                frame.add(editField);

                editButton2 = new JButton("Cari");
                editButton2.setBounds(10, 390, 70, 20);
                frame.add(editButton2);
                frame.revalidate();
                frame.repaint();

                editButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        int book_id = Integer.parseInt(editField.getText());
                        new EditBookInfo(admin_id, book_id);
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
                removeOldComponents();

                tambahLabel = new JLabel("Masukkan id buku:");
                tambahLabel.setBounds(10, 330, 250, 25);
                frame.add(tambahLabel);

                tambahField = new JTextField(15);
                tambahField.setBounds(10, 360, 165, 25);
                frame.add(tambahField);

                tambahButton = new JButton("Cari");
                tambahButton.setBounds(10, 390, 70, 20);
                frame.add(tambahButton);
                frame.revalidate();
                frame.repaint();

                tambahButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose();
                        int book_id = Integer.parseInt(tambahField.getText());
                        new EditBook(book_id, admin_id);
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
                removeOldComponents();

                hapusLabel = new JLabel("Masukkan id buku yang mau di hapus:");
                hapusLabel.setBounds(10, 330, 250, 25);
                frame.add(hapusLabel);

                hapusField = new JTextField(15);
                hapusField.setBounds(10, 360, 165, 25);
                frame.add(hapusField);

                hapusButton = new JButton("Hapus");
                hapusButton.setBounds(10, 390, 70, 20);
                frame.add(hapusButton);
                frame.revalidate();
                frame.repaint();

                hapusButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int book_id = Integer.parseInt(hapusField.getText());
                        int confirm = JOptionPane.showConfirmDialog(frame,
                                "Apakah Anda yakin ingin menghapus buku dengan ID " + book_id + "?", "Konfirmasi Hapus",
                                JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                            boolean success = con.deleteBook(book_id);
                            if (success) {
                                JOptionPane.showMessageDialog(frame, "Buku berhasil dihapus", "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                                new HomeAdmin(admin_id);
                            } else {
                                JOptionPane.showMessageDialog(frame, "Gagal menghapus buku", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        }
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

    private void removeOldComponents() {
        if (editLabel != null)
            frame.remove(editLabel);
        if (editField != null)
            frame.remove(editField);
        if (editButton2 != null)
            frame.remove(editButton2);

        if (tambahLabel != null)
            frame.remove(tambahLabel);
        if (tambahField != null)
            frame.remove(tambahField);
        if (tambahButton != null)
            frame.remove(tambahButton);

        if (hapusLabel != null)
            frame.remove(hapusLabel);
        if (hapusField != null)
            frame.remove(hapusField);
        if (hapusButton != null)
            frame.remove(hapusButton);
    }

    // public static void main(String[] args) {
    // int id = 1;
    // new HomeAdmin(id);
    // }
}
