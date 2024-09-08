package faang.school.godbless.LeaveAComment;

import java.util.Date;

public class Comment {
    private String text;
    private String author;
    private Date date;

    public Comment(String text, String author, Date date) {
        this.text = text;
        this.author = author;
        this.date = date;
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