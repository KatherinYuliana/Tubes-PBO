package model;

public class Admin extends Person{
    private int admin_id;

    public Admin() {

    }

    public Admin(int id, String username, String email, String password, String status, int admin_id) {
        super(id, username, email, password, status);
        this.admin_id = admin_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }
    
    
}
