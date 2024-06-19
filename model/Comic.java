package model;

import java.util.Date;

import model.Enum.BookStatusEnum;
import model.Enum.CategoryBookEnum;
import model.Enum.CategoryComicEnum;
import model.Enum.GenreEnum;

public class Comic extends Book {
    private String ilustrator;
    private CategoryComicEnum category_comic;
    
    public Comic(int book_id, String title, String author, Date publication_year, GenreEnum genre, CategoryBookEnum category,
            double rating, String sinopsis, BookStatusEnum book_status, String ilustrator, CategoryComicEnum category_comic) {
        super(book_id, title, author, publication_year, genre, category, rating, sinopsis, book_status);
        this.ilustrator = ilustrator;
        this.category_comic = category_comic;
    }

    public String getIlustrator() {
        return ilustrator;
    }

    public void setIlustrator(String ilustrator) {
        this.ilustrator = ilustrator;
    }

    public CategoryComicEnum getCategory_comic() {
        return category_comic;
    }

    public void setCategory_comic(CategoryComicEnum category_comic) {
        this.category_comic = category_comic;
    }


}
