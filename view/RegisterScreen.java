package view;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class RegisterScreen {

    public RegisterScreen() {
        JFrame frame = new JFrame("Register Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 300);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 50, 80, 25);
        panel.add(usernameLabel);
        
        JTextField usernameField = new JTextField(15);
        usernameField.setBounds(150, 50, 165, 25);
        panel.add(usernameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 90, 80, 25);
        panel.add(emailLabel);

        JTextField emailField = new JTextField(15);
        emailField.setBounds(150, 90, 165, 25);
        panel.add(emailField);
        
        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 130, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(15);
        passwordField.setBounds(150, 130, 165, 25);
        panel.add(passwordField);
        
        // Submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(150, 170, 100, 25);
        panel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 25);
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
        new RegisterScreen();
    }
}
