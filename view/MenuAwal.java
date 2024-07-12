package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuAwal {

    public MenuAwal() {
        JFrame frame = new JFrame("Login and Register");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 400, 300);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 90, 100, 30);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginScreen();
                frame.setVisible(false);
            }
        });

        // Register button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(140, 140, 100, 30);
        panel.add(registerButton);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterScreen();
                frame.setVisible(false);
            }
        });

        frame.add(panel);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    // new MenuAwal();
    // }
}