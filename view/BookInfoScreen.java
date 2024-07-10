package view;

import javax.swing.*;

import controller.BookController;
import model.Book;
import model.Enum.CategoryBookEnum;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class BookInfoScreen {
    BookController con = BookController.getInstance();
    //CategoryBookEnum category;

    private static ImageIcon scaleImage(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }

    public BookInfoScreen(int book_id, int id) {
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
                new HomeUser(id);
                frame.dispose();
                //frame.setVisible(false);
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
                favoriteButton.setEnabled(false);
            }
        });

       
        ArrayList<Book> showAllBook = con.getBookInfo(book_id);

        //Object[][] data = new Object[showAllBook.size()][4];

        for (int i = 0; i < showAllBook.size(); i++) {
            Book book = showAllBook.get(i);

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
            //     kategori = CategoryBookEnum.NOVEL;
            // }
            JLabel categoryLabel2 = new JLabel(kategori);
            categoryLabel2.setBounds(280, 170, 200, 30);
            frame.add(categoryLabel2);

            //Double rating = book.getRating();
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

        // Chapter 1 button
        JButton chapter1Button = new JButton("Chapter 1");
        chapter1Button.setBounds(50, 320, 700, 40);
        frame.add(chapter1Button);

        chapter1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ChapterScreen(book_id, id);
                frame.dispose();
            }
        });

        // Chapter 2 button
        JButton chapter2Button = new JButton("Chapter 2");
        chapter2Button.setBounds(50, 370, 700, 40);
        frame.add(chapter2Button);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        int book_id = 2;
        int id = 2;
        //String title = "Sherlock Holmes";
        new BookInfoScreen(book_id, id);
    }
}
