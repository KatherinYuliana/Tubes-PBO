package model;

public class User extends Person{
    private int user_id;

    public User () {
    }

    public User(int id, String username, String email, String password, String status, int user_id) {
        super(id, username, email, password, status);
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
