package faang.school.godbless.LeaveAComment;

import java.util.List;

public class Post {
    private int id;
    private String title;
    private String text;
    private String author;
    private List<Comment> comments;

    public Post(int id, String title, String text, String author, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void removeComment(Comment comment) {
        this.comments.remove(comment);
    }
}