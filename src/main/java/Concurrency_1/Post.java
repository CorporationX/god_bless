package Concurrency_1;

import java.util.ArrayList;
import java.util.List;

public class Post {

    private String tittle;
    private String text;
    private String author;
    private List<Comment> comments = new ArrayList<>();

    public Post(String tittle, String text, String author) {
        this.tittle = tittle;
        this.text = text;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void deleteComment(Comment comment, String author) {
        if (comment.getAuthor().equals(author))
            comments.remove(comment);
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTittle() {
        return tittle;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
