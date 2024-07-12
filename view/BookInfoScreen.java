package view;

import javax.swing.*;

import controller.BookController;
import controller.UserController;
import model.Book;
import model.Chapter;
import model.Favorite;
import model.Enum.CategoryBookEnum;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BookInfoScreen {
    BookController con = BookController.getInstance();
    UserController con2 = UserController.getInstance();
    // CategoryBookEnum category;

    private static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public BookInfoScreen(int book_id, int user_id, String book_title) {
        JFrame frame = new JFrame("Book Info");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 10, 80, 30);
        frame.add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeUser(user_id);
                frame.dispose();
                // frame.setVisible(false);
            }
        });

        // Book cover
        JLabel bookCover = new JLabel();
        bookCover.setBounds(50, 70, 150, 200);
        bookCover.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(bookCover);

        // Book title
        // JLabel titleLabel = new JLabel("Judul buku");
        // titleLabel.setBounds(220, 70, 200, 30);
        // titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        // frame.add(titleLabel);

        // Author label
        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(220, 110, 200, 30);
        frame.add(authorLabel);

        // Publication label
        JLabel yearLabel = new JLabel("Publication Year:");
        yearLabel.setBounds(220, 130, 200, 30);
        frame.add(yearLabel);

        // Genre label
        JLabel genreLabel = new JLabel("Genre:");
        genreLabel.setBounds(220, 150, 200, 30);
        frame.add(genreLabel);

        // Category label
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setBounds(220, 170, 200, 30);
        frame.add(categoryLabel);

        // Rating label
        JLabel ratingLabel = new JLabel("Rating:");
        ratingLabel.setBounds(220, 190, 200, 30);
        frame.add(ratingLabel);

        // Status label
        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(220, 210, 200, 30);
        frame.add(statusLabel);

        // Sinopsis label
        JLabel sinopsisLabel = new JLabel("Sinopsis:");
        sinopsisLabel.setBounds(220, 230, 200, 30);
        frame.add(sinopsisLabel);

        // Add to favorite button
        JButton favoriteButton = new JButton("Tambah Favorit");
        favoriteButton.setBounds(50, 280, 150, 30);
        frame.add(favoriteButton);

        favoriteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // String bookId = "someBookId"; // Replace with actual book ID
                // ArrayList<Favorite> cekList = con.cekFavoriteList(user_id);
                // for (int i = 0; i < cekList.size(); i++) {
                //     Favorite favorite = cekList.get(i);
                // int book_id = favorite.
                // boolean cekList = con.cekFavoriteList(book_id);
                // if (cekList) {
                //     favoriteButton.setEnabled(false);
                // } else {
                    // addBookToFavorites(bookId);
                    
                    ArrayList<Book> listFavorite = con.getFavoriteList(user_id);
                    Favorite newFavorite = new Favorite(0, user_id, book_id, listFavorite.size() + 1);
                    // Book newBook = new Book(0, book_title, author, year, genre, category, rating,
                    // sinopsis, book_status,
                    // book_cover, listBook.size() + 1);
                    boolean cek = con2.addFavorite(newFavorite, user_id, book_id);
                    if (cek) {
                        JOptionPane.showMessageDialog(frame, "Buku ditambahkan ke favorit", "Success",
                                JOptionPane.WARNING_MESSAGE);
                                favoriteButton.setEnabled(false);
                        // new EditBook(book_id, user_id);
                        // frame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Buku gagal ditambah ke favorit", "Error",
                                JOptionPane.WARNING_MESSAGE);
                    }
                    //JOptionPane.showMessageDialog(frame, "Buku ditambahkan ke favorit");
                //}
            }
            //}
        });

        // favoriteButton.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // favoriteButton.setEnabled(false);
        // }
        // });
        // Book book1 = new Book();
        // int book_id2 = book1.getBook_id();
        ArrayList<Book> showAllBook = con.getBookInfo(book_id, book_title);
        // System.out.println(book_id2);

        // System.out.println(book_title);

        // Object[][] data = new Object[showAllBook.size()][4];

        for (int i = 0; i < showAllBook.size(); i++) {
            Book book = showAllBook.get(i);
            System.out.println(book.getBook_id());

            String cover = book.getBook_cover();
            JLabel bookCover2 = new JLabel(scaleImage(cover, 150, 200));
            bookCover2.setBounds(50, 70, 150, 200);
            frame.add(bookCover2);

            String judul = book.getBook_title();
            JLabel titleLabel = new JLabel(judul);
            titleLabel.setBounds(220, 70, 500, 30);
            titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
            frame.add(titleLabel);

            String author = book.getAuthor();
            JLabel authorLabel2 = new JLabel(author);
            authorLabel2.setBounds(265, 110, 200, 30);
            frame.add(authorLabel2);

            String tahun = book.getPublication_year().toString();
            JLabel yearLabel2 = new JLabel(tahun);
            yearLabel2.setBounds(320, 130, 200, 30);
            frame.add(yearLabel2);

            String genre = book.getGenre();
            JLabel genreLabel2 = new JLabel(genre);
            genreLabel2.setBounds(265, 150, 200, 30);
            frame.add(genreLabel2);

            String kategori = book.getCategory();
            // if (kategori == "Novel") {
            // kategori = CategoryBookEnum.NOVEL;
            // }
            JLabel categoryLabel2 = new JLabel(kategori);
            categoryLabel2.setBounds(280, 170, 200, 30);
            frame.add(categoryLabel2);

            // Double rating = book.getRating();
            String rating = String.valueOf(book.getRating());
            JLabel ratingLabel2 = new JLabel(rating);
            ratingLabel2.setBounds(265, 190, 200, 30);
            frame.add(ratingLabel2);

            String status = book.getBook_status();
            JLabel statusLabel2 = new JLabel(status);
            statusLabel2.setBounds(265, 210, 200, 30);
            frame.add(statusLabel2);

            String sinopsis = book.getSinopsis();
            JLabel sinopsisLabel2 = new JLabel(sinopsis);
            sinopsisLabel2.setBounds(275, 230, 500, 30);
            frame.add(sinopsisLabel2);
            // JLabel bookCover2 = new JLabel(cover);
            // bookCover2.setBounds(50, 70, 150, 200);
            // //bookCover2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            // frame.add(bookCover2);

            // data[i][0] = book.getBook_id();
            // data[i][1] = book.getBook_title();
            // data[i][2] = book.getAuthor();
            // data[i][3] = book.getCategory();
        }
        

        ArrayList<Chapter> showChapter = con.getChapter(book_id);
        int y = 320;
        for (int i = 0; i < showChapter.size(); i++) {
            Chapter chapter = showChapter.get(i);

            String judul_chapter = chapter.getChapter_title();
            JButton chapterButton = new JButton(judul_chapter);
            chapterButton.setBounds(50, y, 700, 40);
            frame.add(chapterButton);

            int chapter_id = chapter.getChapter_id();
            y += 50;

            chapterButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // int chapter_id = 1;
                    // System.out.println("chapter id " + chapter_id);
                    new ChapterScreen(book_id, user_id, chapter_id);
                    frame.dispose();
                }
            });
        }

        // // Chapter 1 button
        // JButton chapter1Button = new JButton("Chapter 1");
        // chapter1Button.setBounds(50, 320, 700, 40);
        // frame.add(chapter1Button);

        // chapter1Button.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // int chapter_id = 1;
        // new ChapterScreen(book_id, id, chapter_id);
        // frame.dispose();
        // }
        // });

        // // Chapter 2 button
        // JButton chapter2Button = new JButton("Chapter 2");
        // chapter2Button.setBounds(50, 370, 700, 40);
        // frame.add(chapter2Button);

        // chapter2Button.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // int chapter_id = 2;
        // new ChapterScreen(book_id, id, chapter_id);
        // frame.dispose();
        // }
        // });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        int book_id = 1;
        int user_id = 5;
        String book_title = "Harry Potter";
        new BookInfoScreen(book_id, user_id, book_title);
    }
}
