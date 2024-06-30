package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class ScheduleScreen {

    private JLabel[] imageLabels;
    private HashMap<String, String[]> dayImages;

    public ScheduleScreen() {
        JFrame frame = new JFrame("Jadwal");
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

        // Search bar
        JTextField searchField = new JTextField();
        searchField.setBounds(200, 50, 400, 30);
        panel.add(searchField);
        
        // Search button
        JButton searchButton = new JButton("Cari");
        searchButton.setBounds(610, 50, 80, 30);
        panel.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        // Create buttons for days
        String[] days = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu"};
        int xPos = 10;
        for (String day : days) {
            JButton dayButton = new JButton(day);
            dayButton.setBounds(xPos, 100, 100, 30);
            dayButton.addActionListener(new DayButtonListener(day));
            panel.add(dayButton);
            xPos += 110;
        }

        // Initialize labels to display images
        imageLabels = new JLabel[3];
        int imgXPos = 10;
        for (int i = 0; i < imageLabels.length; i++) {
            imageLabels[i] = new JLabel();
            imageLabels[i].setBounds(imgXPos, 150, 130, 200);
            panel.add(imageLabels[i]);
            imgXPos += 160;
        }

        // Initialize day to image paths mapping
        dayImages = new HashMap<>();
        dayImages.put("Senin", new String[]{"pictures/One Piece.jpg", "pictures/Jujutsu Kaisen.jpg", "path/to/senin3.jpg"});
        dayImages.put("Selasa", new String[]{"pictures/Sherlock Holmes.jpg", "path/to/selasa2.jpg", "path/to/selasa3.jpg"});
        dayImages.put("Rabu", new String[]{"path/to/rabu1.jpg", "path/to/rabu2.jpg", "path/to/rabu3.jpg"});
        dayImages.put("Kamis", new String[]{"path/to/kamis1.jpg", "path/to/kamis2.jpg", "path/to/kamis3.jpg"});
        dayImages.put("Jumat", new String[]{"path/to/jumat1.jpg", "path/to/jumat2.jpg", "path/to/jumat3.jpg"});
        dayImages.put("Sabtu", new String[]{"path/to/sabtu1.jpg", "path/to/sabtu2.jpg", "path/to/sabtu3.jpg"});
        dayImages.put("Minggu", new String[]{"path/to/minggu1.jpg", "path/to/minggu2.jpg", "path/to/minggu3.jpg"});
        
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

        // Action listener class for day buttons
    private class DayButtonListener implements ActionListener {
        private String day;

        public DayButtonListener(String day) {
            this.day = day;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // Set the images based on the day
            String[] images = dayImages.get(day);
            for (int i = 0; i < imageLabels.length; i++) {
                if (images != null && i < images.length) {
                    ImageIcon imageIcon = new ImageIcon(images[i]);
                    Image img = imageIcon.getImage();
                    Image scaledImg = img.getScaledInstance(130, 200, Image.SCALE_SMOOTH);
                    imageLabels[i].setIcon(new ImageIcon(scaledImg));
                } else {
                    imageLabels[i].setIcon(null);
                }
            }
            }
            }
            
    public static void main(String[] args) {
        new ScheduleScreen();
    }
}
