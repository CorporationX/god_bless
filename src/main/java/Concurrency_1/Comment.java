package Concurrency_1;

import java.util.Date;

public class Comment {

    private String text;
    private String author;
    private Date date;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.date = new Date();
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }
}
