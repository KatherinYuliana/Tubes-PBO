package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Book;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class ScheduleScreen {

    private JFrame frame;
    private JLabel image1;
    private JLabel[] imageLabels;
    private HashMap<String, String[]> dayImages;

    private static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public ScheduleScreen(int book_id, int user_id) {
        frame = new JFrame("Jadwal");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // JPanel panel = new JPanel();
        // panel.setLayout(null);
        // panel.setBounds(0, 0, 800, 600);

        // Home button
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(10, 10, 80, 30);
        frame.add(homeButton);

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeUser(user_id);
                frame.setVisible(false);
            }
        });

        // Jadwal button
        JButton jadwalButton = new JButton("Jadwal");
        jadwalButton.setBounds(100, 10, 80, 30);
        frame.add(jadwalButton);

        jadwalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ScheduleScreen(book_id, user_id);
                frame.setVisible(false);
            }
        });

        // Favorit button
        JButton favoritButton = new JButton("Favorit");
        favoritButton.setBounds(190, 10, 80, 30);
        frame.add(favoritButton);

        favoritButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FavoriteScreen(user_id);
                frame.setVisible(false);
            }
        });

        // Search
        JTextField searchField = new JTextField();
        searchField.setBounds(150, 60, 400, 30);
        frame.add(searchField);

        JButton searchButton = new JButton("Cari");
        searchButton.setBounds(560, 60, 80, 30);
        frame.add(searchButton);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // Senin
        JButton seninButton = new JButton("Senin");
        seninButton.setBounds(10, 100, 100, 30);
        frame.add(seninButton);

        seninButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image1 != null) {
                    frame.remove(image1);
                }

                image1 = new JLabel(scaleImage("pictures/comic/One Piece.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // frame.dispose();
                        // int book_id = 4;
                        // // String title = "One Piece";
                        // new BookInfoScreen(book_id, id);

                        Book book = new Book();

                        frame.dispose();
                        int no = 4;
                        int book_id = book.getBook_id();
                        book_id = no;
                        //System.out.println(book_id);
                        //String title = "One Piece";
                        new BookInfoScreen(book_id, user_id, "");
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

                frame.revalidate();
                frame.repaint();
            }
        });

        // Selasa
        JButton selasaButton = new JButton("Selasa");
        selasaButton.setBounds(120, 100, 100, 30);
        frame.add(selasaButton);

        selasaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image1 != null) {
                    frame.remove(image1);
                }

                image1 = new JLabel(scaleImage("pictures/comic/Jujutsu Kaisen.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // frame.dispose();
                        // int book_id = 2;
                        // // String title = "One Piece";
                        // new BookInfoScreen(book_id, id);

                        Book book = new Book();

                        frame.dispose();
                        int no = 2;
                        int book_id = book.getBook_id();
                        book_id = no;
                        //System.out.println(book_id);
                        //String title = "One Piece";
                        new BookInfoScreen(book_id, user_id, "");
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
                frame.revalidate();
                frame.repaint();
            }
        });

        // Rabu
        JButton rabuButton = new JButton("Rabu");
        rabuButton.setBounds(230, 100, 100, 30);
        frame.add(rabuButton);

        rabuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image1 != null) {
                    frame.remove(image1);
                }

                image1 = new JLabel(scaleImage("pictures/comic/Black Butler.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        // frame.dispose();
                        // int book_id = 5;
                        // // String title = "One Piece";
                        // new BookInfoScreen(book_id, id);

                        Book book = new Book();

                        frame.dispose();
                        int no = 5;
                        int book_id = book.getBook_id();
                        book_id = no;
                        //System.out.println(book_id);
                        //String title = "One Piece";
                        new BookInfoScreen(book_id, user_id, "");
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

                frame.revalidate();
                frame.repaint();
            }
        });

        // Kamis
        JButton kamisButton = new JButton("Kamis");
        kamisButton.setBounds(340, 100, 100, 30);
        frame.add(kamisButton);

        kamisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image1 != null) {
                    frame.remove(image1);
                }

                image1 = new JLabel(scaleImage("pictures/comic/One Piece.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        frame.dispose();
                        int book_id = 4;
                        // String title = "One Piece";
                        new BookInfoScreen(book_id, user_id, "");
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

                frame.revalidate();
                frame.repaint();
            }
        });

        // Jumat
        JButton jumatButton = new JButton("Jumat");
        jumatButton.setBounds(450, 100, 100, 30);
        frame.add(jumatButton);

        jumatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image1 != null) {
                    frame.remove(image1);
                }

                image1 = new JLabel(scaleImage("pictures/comic/One Piece.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        frame.dispose();
                        int book_id = 4;
                        // String title = "One Piece";
                        new BookInfoScreen(book_id, user_id, "");
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

                frame.revalidate();
                frame.repaint();
            }
        });

        // Sabtu
        JButton sabtuButton = new JButton("Sabtu");
        sabtuButton.setBounds(560, 100, 100, 30);
        frame.add(sabtuButton);

        sabtuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image1 != null) {
                    frame.remove(image1);
                }

                image1 = new JLabel(scaleImage("pictures/comic/One Piece.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        frame.dispose();
                        int book_id = 4;
                        // String title = "One Piece";
                        new BookInfoScreen(book_id, user_id, "");
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

                frame.revalidate();
                frame.repaint();
            }
        });

        // Minggu
        JButton mingguButton = new JButton("Minggu");
        mingguButton.setBounds(670, 100, 100, 30);
        frame.add(mingguButton);

        mingguButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (image1 != null) {
                    frame.remove(image1);
                }

                image1 = new JLabel(scaleImage("pictures/comic/One Piece.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        frame.dispose();
                        int book_id = 4;
                        // String title = "One Piece";
                        new BookInfoScreen(book_id, user_id, "");
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

                frame.revalidate();
                frame.repaint();
            }
        });

        // Create buttons for days
        // String[] days = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu",
        // "Minggu"};
        // int xPos = 10;
        // for (String day : days) {
        // JButton dayButton = new JButton(day);
        // dayButton.setBounds(xPos, 100, 100, 30);
        // dayButton.addActionListener(new DayButtonListener(day));
        // panel.add(dayButton);
        // xPos += 110;
        // }

        // Initialize labels to display images
        // imageLabels = new JLabel[3];
        // int imgXPos = 10;
        // for (int i = 0; i < imageLabels.length; i++) {
        // imageLabels[i] = new JLabel();
        // imageLabels[i].setBounds(imgXPos, 150, 130, 200);
        // panel.add(imageLabels[i]);
        // imgXPos += 160;
        // }

        // Initialize day to image paths mapping
        // dayImages = new HashMap<>();
        // //dayImages.put("Senin", new String[]{"pictures/One Piece.jpg",
        // "pictures/Jujutsu Kaisen.jpg", "path/to/senin3.jpg"});
        // dayImages.put("Selasa", new String[]{"pictures/Sherlock Holmes.jpg",
        // "path/to/selasa2.jpg", "path/to/selasa3.jpg"});
        // dayImages.put("Rabu", new String[]{"path/to/rabu1.jpg", "path/to/rabu2.jpg",
        // "path/to/rabu3.jpg"});
        // dayImages.put("Kamis", new String[]{"path/to/kamis1.jpg",
        // "path/to/kamis2.jpg", "path/to/kamis3.jpg"});
        // dayImages.put("Jumat", new String[]{"path/to/jumat1.jpg",
        // "path/to/jumat2.jpg", "path/to/jumat3.jpg"});
        // dayImages.put("Sabtu", new String[]{"path/to/sabtu1.jpg",
        // "path/to/sabtu2.jpg", "path/to/sabtu3.jpg"});
        // dayImages.put("Minggu", new String[]{"path/to/minggu1.jpg",
        // "path/to/minggu2.jpg", "path/to/minggu3.jpg"});

        // Log out button
        JButton logoutButton = new JButton("Log out");
        logoutButton.setBounds(700, 10, 80, 30);
        frame.add(logoutButton);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAwal();
                frame.setVisible(false);
            }
        });

        //frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Action listener class for day buttons
    // private class DayButtonListener implements ActionListener {
    //     private String day;

    //     public DayButtonListener(String day) {
    //         this.day = day;
    //     }

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         // Set the images based on the day
    //         String[] images = dayImages.get(day);
    //         for (int i = 0; i < imageLabels.length; i++) {
    //             if (images != null && i < images.length) {
    //                 ImageIcon imageIcon = new ImageIcon(images[i]);
    //                 Image img = imageIcon.getImage();
    //                 Image scaledImg = img.getScaledInstance(130, 200, Image.SCALE_SMOOTH);
    //                 imageLabels[i].setIcon(new ImageIcon(scaledImg));
    //             } else {
    //                 imageLabels[i].setIcon(null);
    //             }
    //         }
    //     }
    // }

    public static void main(String[] args) {
        int book_id = 2;
        int id = 2;
        new ScheduleScreen(book_id, id);
    }
}
