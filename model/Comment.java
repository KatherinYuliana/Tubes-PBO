package model;

public class Comment {
    private int comment_id;
    private String comment_content;

    public Comment() {
    }

    public Comment(int comment_id, String comment_content) {
        this.comment_id = comment_id;
        this.comment_content = comment_content;
    }
    
    public int getComment_id() {
        return comment_id;
    }
    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }
    public String getComment_content() {
        return comment_content;
    }
    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    
}
