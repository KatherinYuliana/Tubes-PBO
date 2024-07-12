package view;

import controller.BookController;
import controller.UserController;
import model.Comment;
import model.Person;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CommentScreen {
    BookController con = BookController.getInstance();
    UserController con2 = UserController.getInstance();

    public CommentScreen(int user_id, int chapter_id) {
        JFrame frame = new JFrame("Comments Section");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        JPanel commentsPanel = new JPanel();
        commentsPanel.setLayout(new BoxLayout(commentsPanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(commentsPanel);
        scrollPane.setBounds(10, 10, 360, 200);
        frame.add(scrollPane);

        ArrayList<Comment> showComment = con.getComment(chapter_id);
        ArrayList<Person> showUserComment = con2.getUserComment(chapter_id);

        if (showComment.isEmpty()) {
            JLabel emptyLabel = new JLabel("Komentar Kosong");
            emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
            emptyLabel.setVerticalAlignment(SwingConstants.CENTER);
            emptyLabel.setBounds(0, 0, 360, 260);
            commentsPanel.add(emptyLabel);
        } else {
            for (int i = 0; i < showComment.size(); i++) {

                Color color2 = new Color(255, 255, 255);
                JPanel komenPanel = new JPanel();
                komenPanel.setLayout(null);
                komenPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                komenPanel.setBounds(20, 50, 30, 30);
                komenPanel.setBackground(color2);

                Comment comment = showComment.get(i);
                Person person = showUserComment.get(i);

                JLabel userLabel = new JLabel("Username: " + person.getUsername());
                userLabel.setBounds(10, 0, 400, 30);
                komenPanel.add(userLabel);

                JLabel komenLabel = new JLabel("Komentar: " + comment.getComment_content());
                komenLabel.setBounds(10, 20, 400, 30);
                komenPanel.add(komenLabel);

                commentsPanel.add(komenPanel);
            }

        }

        JTextField textField = new JTextField();
        textField.setBounds(10, 220, 270, 30);
        frame.add(textField);
        JButton sendButton = new JButton("Kirim");
        sendButton.setBounds(290, 220, 80, 30);
        frame.add(sendButton);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String komen = textField.getText();
                ArrayList<Comment> listComment = con.getComment(chapter_id);
                Comment newComment = new Comment(0, user_id, chapter_id, komen, listComment.size() + 1);

                boolean cek = con2.addComment(newComment, user_id, chapter_id);
                if (cek) {
                    JOptionPane.showMessageDialog(frame, "Komentar berhasil dikirim", "Success",
                            JOptionPane.WARNING_MESSAGE);
                    new CommentScreen(user_id, chapter_id);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Komentar gagal terkirim", "Error",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    // int id = 2;
    // int chapter_id = 2;
    // new CommentScreen(id, chapter_id);
    // }
}