package model;

public class Favorite {
    private int favorite_id;

    public Favorite() {
    }

    public Favorite(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public Favorite(int favorite_id, int user_id, int book_id, int j) {
        this.favorite_id = favorite_id;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }    
}
