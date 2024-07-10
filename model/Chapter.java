package model;

public class Chapter {
    private int chapter_id;
    private String chapter_title;
    private String chapter_content;

    public Chapter(int chapter_id, String chapter_title, String chapter_content) {
        this.chapter_id = chapter_id;
        this.chapter_title = chapter_title;
        this.chapter_content = chapter_content;
    }
    
    public int getChapter_id() {
        return chapter_id;
    }
    public void setChapter_id(int chapter_id) {
        this.chapter_id = chapter_id;
    }
    public String getChapter_title() {
        return chapter_title;
    }
    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }
    public String getChapter_content() {
        return chapter_content;
    }
    public void setChapter_content(String chapter_content) {
        this.chapter_content = chapter_content;
    }

    
}
