package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CommentsSection {
    private JFrame frame;
    private JPanel commentsPanel;
    private JTextField textField;
    private JButton sendButton;

    public CommentsSection() {
        frame = new JFrame("Comments Section");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Comments panel inside a scroll pane
        commentsPanel = new JPanel();
        commentsPanel.setLayout(new BoxLayout(commentsPanel, BoxLayout.Y_AXIS));
        commentsPanel.setBackground(Color.CYAN);

        JScrollPane scrollPane = new JScrollPane(commentsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        textField = new JTextField();
        sendButton = new JButton("Kirim");
        sendButton.addActionListener(e -> addComment());

        inputPanel.add(textField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        // Add components to main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(inputPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void addComment() {
        String commentText = textField.getText();
        if (!commentText.isEmpty()) {
            JPanel commentPanel = new JPanel();
            commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));
            commentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel usernameLabel = new JLabel("username");
            JLabel commentLabel = new JLabel(commentText);

            commentPanel.add(usernameLabel);
            commentPanel.add(commentLabel);

            commentsPanel.add(commentPanel);
            commentsPanel.revalidate();
            commentsPanel.repaint();

            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new CommentsSection();
    }
}
