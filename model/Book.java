package model;

import java.util.Date;

import model.Enum.BookStatusEnum;
import model.Enum.CategoryBookEnum;
import model.Enum.GenreEnum;

public class Book {
    private int book_id;
    private String title;
    private String author;
    private Date publication_year;
    private GenreEnum genre;
    private CategoryBookEnum category;
    private double rating;
    private String sinopsis;
    private BookStatusEnum book_status;
    
    public Book(int book_id, String title, String author, Date publication_year, GenreEnum genre, CategoryBookEnum category, double rating,
            String sinopsis, BookStatusEnum book_status) {
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.publication_year = publication_year;
        this.genre = genre;
        this.category = category;
        this.rating = rating;
        this.sinopsis = sinopsis;
        this.book_status = book_status;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Date getPublication_year() {
        return publication_year;
    }
    public void setPublication_year(Date publication_year) {
        this.publication_year = publication_year;
    }
    public GenreEnum getGenre() {
        return genre;
    }
    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }
    public CategoryBookEnum getCategory() {
        return category;
    }
    public void setCategory(CategoryBookEnum category) {
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

    public BookStatusEnum getBook_status() {
        return book_status;
    }

    public void setBook_status(BookStatusEnum book_status) {
        this.book_status = book_status;
    }


}
