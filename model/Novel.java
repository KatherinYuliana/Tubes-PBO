package model;

public class Novel extends Book{
    public Novel () {
    }

    public Novel(int book_id, String book_title, String author, String publication_year, String genre, String category,
            double rating, String sinopsis, String book_status, String book_cover, int novel_id) {
        super(book_id, book_title, author, publication_year, genre, category, rating, sinopsis, book_status,
                book_cover);
    }

    public Novel(int book_id, String book_title, String author, String publication_year, String genre, String category,
            double rating, String sinopsis, String book_status, String book_cover, int i, int novel_id) {
        super(book_id, book_title, author, publication_year, genre, category, rating, sinopsis, book_status, book_cover,
                i);
    }
}
