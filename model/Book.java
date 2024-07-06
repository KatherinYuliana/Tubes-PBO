package model;

import java.sql.Blob;
import java.util.Date;

import model.Enum.BookStatusEnum;
import model.Enum.CategoryBookEnum;
import model.Enum.GenreEnum;

public class Book {
    private int book_id;
    private String book_title;
    private String author;
    private String publication_year;
    private String genre;
    private String category;
    private double rating;
    private String sinopsis;
    private String book_status;
    private String book_cover;

    public Book() {

    }

    public Book(int book_id, String book_title, String author, String publication_year, String genre, String category,
            double rating,
            String sinopsis, String book_status, String book_cover) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.author = author;
        this.publication_year = publication_year;
        this.genre = genre;
        this.category = category;
        this.rating = rating;
        this.sinopsis = sinopsis;
        this.book_status = book_status;
        this.book_cover = book_cover;
    }

    public Book(int book_id, String book_title, String author, String publication_year, String genre, String category, double rating, 
            String sinopsis, String book_status, String book_cover, int i) {
        this.book_id = book_id;
        this.book_title = book_title;
        this.author = author;
        this.publication_year = publication_year;
        this.genre = genre;
        this.category = category;
        this.rating = rating;
        this.sinopsis = sinopsis;
        this.book_status = book_status;
        this.book_cover = book_cover;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublication_year() {
        return publication_year;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getBook_status() {
        return book_status;
    }

    public void setBook_status(String book_status) {
        this.book_status = book_status;
    }

    public String getBook_cover() {
        return book_cover;
    }

    public void setBook_cover(String book_cover) {
        this.book_cover = book_cover;
    }

    // public Blob getBook_cover() {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'getBook_cover'");
    // }

}
