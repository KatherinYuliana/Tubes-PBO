package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Image;

public class HomeUser {

    private static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public HomeUser() {
        JFrame frame = new JFrame("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);

        // Home button
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(10, 10, 80, 30);
        panel.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeUser();
                frame.setVisible(false);
            }
        });

        // Jadwal button
        JButton jadwalButton = new JButton("Jadwal");
        jadwalButton.setBounds(100, 10, 80, 30);
        panel.add(jadwalButton);

        jadwalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScheduleScreen();
                frame.setVisible(false);
            }
        });

        // Favorit button
        JButton favoritButton = new JButton("Favorit");
        favoritButton.setBounds(190, 10, 80, 30);
        panel.add(favoritButton);

        favoritButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FavoriteScreen();
                frame.setVisible(false);
            }
        });

        // Search 
        JTextField searchField = new JTextField();
        searchField.setBounds(150, 70, 400, 30);
        panel.add(searchField);

        JButton searchButton = new JButton("Cari");
        searchButton.setBounds(560, 70, 80, 30);
        panel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        // Recommendations book
        JLabel recommendationsLabel = new JLabel("Rekomendasi untuk anda");
        recommendationsLabel.setBounds(50, 120, 200, 30);
        panel.add(recommendationsLabel);

        JLabel image1 = new JLabel(scaleImage("pictures/One Piece.jpg", 100, 150));
        image1.setBounds(50, 160, 100, 150);
        panel.add(image1);

        image1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                int id = 4;
                //String title = "One Piece";
                new BookInfoScreen(id);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        //JLabel image2 = new JLabel("Sherlock Holmes");
        JLabel image2 = new JLabel(scaleImage("pictures/Sherlock Holmes.jpg", 100, 150));
        image2.setBounds(200, 160, 100, 150);
        panel.add(image2);

        image2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.dispose();
                int id = 3;
                //String title = "";
                new BookInfoScreen(id);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        
        JLabel image3 = new JLabel("gambar 3");
        image3.setBounds(350, 160, 100, 150);
        panel.add(image3);
        
        // Popular list book
        JLabel popularLabel = new JLabel("Daftar populer");
        popularLabel.setBounds(50, 330, 200, 30);
        panel.add(popularLabel);

        JLabel image4 = new JLabel("gambar 4");
        image4.setBounds(50, 370, 100, 150);
        panel.add(image4);
        
        JLabel image5 = new JLabel("gambar 5");
        image5.setBounds(200, 370, 100, 150);
        panel.add(image5);
        
        // Log out button
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(700, 10, 80, 30);
        panel.add(logoutButton);
        
        logoutButton.addActionListener(new ActionListener() {
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
        new HomeUser();
    }
}
