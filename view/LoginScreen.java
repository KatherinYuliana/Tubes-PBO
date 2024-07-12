package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.Account;
import model.Admin;
import model.Person;
import model.User;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen {
    Account con = Account.getInstance();

    public LoginScreen() {
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 300);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 70, 80, 25);
        panel.add(usernameLabel);

        JTextField usernameField = new JTextField(15);
        usernameField.setBounds(150, 70, 165, 25);
        panel.add(usernameField);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 110, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBounds(150, 110, 165, 25);
        panel.add(passwordField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 100, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Person loggedInUser = con.getAccount(username, password);

                if (loggedInUser instanceof User) {
                    frame.dispose();
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + username);
                    int user_id = loggedInUser.getId();
                    new HomeUser(user_id);
                } else if (loggedInUser instanceof Admin) {
                    frame.dispose();
                    JOptionPane.showMessageDialog(null, "Selamat Datang Admin");
                    int admin_id = loggedInUser.getId();
                    new HomeAdmin(admin_id);
                } else {
                    JOptionPane.showMessageDialog(frame, "Username atau password salah", "User not found",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 75, 25);
        panel.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAwal();
                frame.setVisible(false);
            }
        });

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    // new LoginScreen();
    // }
}