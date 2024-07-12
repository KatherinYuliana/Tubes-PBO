package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.BookController;
import model.Book;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ScheduleScreen {
    private JFrame frame;
    private JLabel image1;
    BookController con = BookController.getInstance();

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
                String book_title = searchField.getText();
                ArrayList<Book> searchBook = con.getBookInfo(0, book_title);
                if (searchBook.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Buku yang dicari tidak ada", "Error",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    Book book = searchBook.get(0);
                    int book_id = book.getBook_id();
                    new BookInfoScreen(book_id, user_id, book_title);
                    frame.dispose();
                }

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
                        Book book = new Book();
                        frame.dispose();
                        int no = 4;
                        int book_id = book.getBook_id();
                        book_id = no;
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
                        Book book = new Book();
                        frame.dispose();
                        int no = 2;
                        int book_id = book.getBook_id();
                        book_id = no;
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
                        Book book = new Book();
                        frame.dispose();
                        int no = 5;
                        int book_id = book.getBook_id();
                        book_id = no;
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

                image1 = new JLabel(scaleImage("pictures/comic/Kimetsu no Yaiba.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Book book = new Book();
                        frame.dispose();
                        int no = 10;
                        int book_id = book.getBook_id();
                        book_id = no;
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

                image1 = new JLabel(scaleImage("pictures/comic/Dreaming Freedom.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Book book = new Book();
                        frame.dispose();
                        int no = 11;
                        int book_id = book.getBook_id();
                        book_id = no;
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

                image1 = new JLabel(scaleImage("pictures/comic/Ao Haru Ride.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Book book = new Book();
                        frame.dispose();
                        int no = 12;
                        int book_id = book.getBook_id();
                        book_id = no;
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

                image1 = new JLabel(scaleImage("pictures/comic/Tower Of God.jpg", 130, 200));
                image1.setBounds(10, 150, 130, 200);
                frame.add(image1);

                image1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Book book = new Book();
                        frame.dispose();
                        int no = 13;
                        int book_id = book.getBook_id();
                        book_id = no;
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

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // public static void main(String[] args) {
    // int book_id = 2;
    // int id = 2;
    // new ScheduleScreen(book_id, id);
    // }
}
