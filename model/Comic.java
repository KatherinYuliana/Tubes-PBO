package model;

import model.Enum.CategoryComicEnum;

public class Comic extends Book {
    private String ilustrator;
    private CategoryComicEnum category_comic;
    
    public Comic() {
    }

    public Comic(int book_id, String title, String author, String publication_year, String genre, String category,
            double rating, String sinopsis, String book_status, String book_cover, String ilustrator,
            CategoryComicEnum category_comic) {
        super(book_id, title, author, publication_year, genre, category, rating, sinopsis, book_status, book_cover);
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
