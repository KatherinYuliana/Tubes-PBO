package view;

import javax.swing.*;
import java.awt.*;

public class CommentsSectionGUI {
    public CommentsSectionGUI() {
        JFrame frame = new JFrame("Comments Section");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Main panel for comments
        JPanel commentsPanel = new JPanel();
        commentsPanel.setLayout(new BoxLayout(commentsPanel, BoxLayout.Y_AXIS));

        // Scroll pane for comments
        JScrollPane scrollPane = new JScrollPane(commentsPanel);
        scrollPane.setBounds(10, 10, 360, 200);
        frame.add(scrollPane);

        // // Text field for new comment
        // JTextField commentField = new JTextField();
        // commentField.setBounds(10, 620, 440, 30);
        // frame.add(commentField);

        // // Send button for new comment
        // JButton sendButton = new JButton("Kirim");
        // sendButton.setBounds(460, 620, 80, 30);
        // frame.add(sendButton);

        JTextField textField = new JTextField();
        textField.setBounds(10, 220, 270, 30);
        frame.add(textField);
        JButton sendButton = new JButton("Kirim");
        sendButton.setBounds(290, 220, 80, 30);
        frame.add(sendButton);


        // Example comments
        for (int i = 0; i < 5; i++) {
            JPanel commentPanel = new JPanel();
            commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));
            commentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            commentPanel.setPreferredSize(new Dimension(340, 50));

            JLabel userNameLabel = new JLabel("User_" + (i + 1));
            JTextArea commentTextArea = new JTextArea("This is a comment. This is a comment. This is a comment.");
            commentTextArea.setLineWrap(true);
            commentTextArea.setWrapStyleWord(true);
            commentTextArea.setEditable(false);

            commentPanel.add(userNameLabel);
            commentPanel.add(commentTextArea);
            commentsPanel.add(commentPanel);
        }

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new CommentsSectionGUI();
    }
}


// package view;

// import java.awt.BorderLayout;
// import java.awt.Color;

// import javax.swing.BorderFactory;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTextArea;
// import javax.swing.JTextField;

// public class CommentScreen {
//     public CommentScreen() {
//         JFrame frame = new JFrame("Comment");
//         frame.setSize(400, 300);
//         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//         frame.setLayout(null);

//         //Color color = new Color(255, 255, 255);
//         JPanel panel = new JPanel();
//         panel.setBounds(10, 10, 360, 200);
//         //panel.setBackground(color);
//         panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//         panel.setLayout(new BorderLayout());
//         frame.add(panel);

//         JTextArea textArea = new JTextArea();
//         textArea.setEditable(false);
//         JScrollPane scrollPane = new JScrollPane(textArea);
//         panel.add(scrollPane);

//         JPanel panel2 = new JPanel();
//         panel.setBounds(20, 20, 340, 30);
//         panel.add(panel2);

//         JTextField textField = new JTextField();
//         textField.setBounds(10, 220, 270, 30);
//         frame.add(textField);
//         JButton sendButton = new JButton("Kirim");
//         sendButton.setBounds(290, 220, 80, 30);
//         frame.add(sendButton);

//         frame.setLocationRelativeTo(null);
//         frame.setVisible(true);
//     }

//     public static void main(String[] args) {
//         new CommentScreen();
//     }
// }
