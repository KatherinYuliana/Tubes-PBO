package view;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFileDisplayGUI {
    public TextFileDisplayGUI() {
        JFrame frame = new JFrame("Text File Display");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 30);
        frame.add(backButton);

        // Panel in the center
        JPanel panel = new JPanel();
        panel.setBounds(50, 50, 500, 400);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.setLayout(new BorderLayout());
        frame.add(panel);

        // Text area to display file content
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Lihat komentar button
        JButton lihatKomentarButton = new JButton("Lihat Komentar");
        lihatKomentarButton.setBounds(230, 500, 140, 30);
        frame.add(lihatKomentarButton);

        // Load file content into text area
        loadFileContent("teks.txt", textArea);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

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

    public static void main(String[] args) {
        new TextFileDisplayGUI();
    }
}

// package view;

// import java.awt.BorderLayout;
// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;

// import javax.swing.JFrame;
// import javax.swing.JOptionPane;
// import javax.swing.JScrollPane;
// import javax.swing.JTextArea;
// import javax.swing.SwingUtilities;

// public class FileViewer extends JFrame {
//     private JTextArea textArea;
    
//     public FileViewer() {
//         setTitle("File Viewer");
//         setSize(600, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);
        
//         textArea = new JTextArea();
//         textArea.setEditable(false);
        
//         JScrollPane scrollPane = new JScrollPane(textArea);
//         add(scrollPane, BorderLayout.CENTER);
        
//         loadFile("teks.txt");
//     }
    
//     private void loadFile(String filePath) {
//         try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 textArea.append(line + "\n");
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//             JOptionPane.showMessageDialog(this, "Error loading file: " + e.getMessage(),
//                                           "Error", JOptionPane.ERROR_MESSAGE);
//         }
//     }
    
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             FileViewer viewer = new FileViewer();
//             viewer.setVisible(true);
//         });
//     }
// }
