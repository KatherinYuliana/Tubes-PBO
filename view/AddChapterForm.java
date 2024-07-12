package view;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.BookController;
import model.Chapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class AddChapterForm {
    private JLabel fileNameLabel;
    private File selectedFile;
    private String filePath;
    BookController con = BookController.getInstance();

    public AddChapterForm(int book_id, int admin_id) {
        JFrame frame = new JFrame("Add Chapter");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JLabel menuLabel = new JLabel("Tambah Chapter");
        menuLabel.setBounds(120, 5, 200, 30);
        menuLabel.setFont(new Font("Serif", Font.BOLD, 15));
        frame.add(menuLabel);

        JLabel titleLabel = new JLabel("Judul Chapter");
        titleLabel.setBounds(10, 60, 100, 25);
        frame.add(titleLabel);
        JLabel titikdua = new JLabel(":");
        titikdua.setBounds(90, 60, 100, 25);
        frame.add(titikdua);
        JTextField titleField = new JTextField();
        titleField.setBounds(100, 60, 220, 25);
        frame.add(titleField);

        JLabel fileLabel = new JLabel("File");
        fileLabel.setBounds(10, 100, 100, 25);
        frame.add(fileLabel);
        JLabel titikdua_2 = new JLabel(":");
        titikdua_2.setBounds(90, 100, 100, 25);
        frame.add(titikdua_2);
        JButton chooseFileButton = new JButton("Pilih File");
        chooseFileButton.setBounds(100, 100, 80, 25);
        frame.add(chooseFileButton);
        fileNameLabel = new JLabel("");
        fileNameLabel.setBounds(200, 100, 240, 25);
        frame.add(fileNameLabel);

        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser(
                        "D:Documents/Kuliah/Semester pendek/PBO/Tubes");
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    fileNameLabel.setText(selectedFile.getName());
                    filePath = selectedFile.getAbsolutePath();
                }
            }
        });

        JButton submitButton = new JButton("Tambah");
        submitButton.setBounds(130, 150, 80, 25);
        frame.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String file = filePath;

                ArrayList<Chapter> listChapter = con.getChapter(book_id);
                Chapter newChapter = new Chapter(0, book_id, title, file, listChapter.size() + 1);
                boolean cek = con.addChapter(newChapter, book_id);
                if (cek) {
                    JOptionPane.showMessageDialog(frame, "Chapter Berhasil Ditambah", "Success",
                            JOptionPane.WARNING_MESSAGE);
                    new EditBook(book_id, admin_id);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Chapter Gagal Ditambah", "Error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    // int book_id = 2;
    // int id = 1;
    // new AddChapterForm(book_id, id);
    // }
}
