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
import java.lang.ModuleLayer.Controller;
import java.util.concurrent.Flow.Publisher;

public class LoginScreen {
    Account con = Account.getInstance();

    public LoginScreen() {
        //Account account = new Account();

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

        // loginButton.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // new HomeUser();
        // frame.setVisible(false);
        // }
        // });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Person loggedInUser = con.getAccount(username, password);


                if (loggedInUser instanceof User) {
                    // if (loggedInUser.getStatus() == AccountStatus.BANNED) {
                    //     JOptionPane.showMessageDialog(null, "This account is banned");
                    //     return;
                    // }
                    //System.out.println(loggedInUser.getId());
                    frame.dispose();
                    JOptionPane.showMessageDialog(null, "Selamat Datang " + username);
                    int id = loggedInUser.getId();
                    new HomeUser(id);
                    //new HomeUser((User) loggedInUser);
                } else if (loggedInUser instanceof Admin) {
                    frame.dispose();
                    JOptionPane.showMessageDialog(null, "Selamat Datang Admin");
                    new HomeAdmin();
                    //new HomeAdmin((Admin) loggedInUser);
                } else {
                    JOptionPane.showMessageDialog(frame, "Username atau password salah", "User not found",
                            JOptionPane.WARNING_MESSAGE);
                }

                // Person person = access.getUser(usernameField.getText(),String.valueOf(passwordField.getPassword()));
                // if (person != null) {
                //     JOptionPane.showMessageDialog(null, "Login Sukses", "Info",
                //     JOptionPane.INFORMATION_MESSAGE);
                //     frame.dispose();
                //     new HomeUser();
                // } else {
                //     JOptionPane.showMessageDialog(null, "Login Gagal. Email atau password salah.", "Error", JOptionPane.ERROR_MESSAGE);
                //     frame.dispose();
                // }

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

    public static void main(String[] args) {
        new LoginScreen();
    }
}