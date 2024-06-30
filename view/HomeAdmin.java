package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdmin {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

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
        
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic for logging out
                new MenuAwal();
                frame.dispose();
            }
        });

        // Menu Admin
        JLabel menuLabel = new JLabel("Menu Admin");
        menuLabel.setBounds(10, 10, 200, 30);
        menuLabel.setFont(new Font("Serif", Font.BOLD, 30));
        frame.add(menuLabel);

        // Tabel
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("ID");
        tableModel.addColumn("Judul Buku");
        tableModel.addColumn("Author");
        tableModel.addColumn("Category");

        JScrollPane scrollPane = new JScrollPane(table);
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

                JButton editButton2 = new JButton("Edit");
                editButton2.setBounds(10, 390, 70, 20);
                frame.add(editButton2);

                frame.revalidate();
                frame.repaint();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new HomeAdmin();
    }
}
