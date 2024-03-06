package faang.school.godbless.comments;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String text;
    private String author;
    private volatile List<Comment> comments = new ArrayList<>();

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", author='" + author + '\'' +
                ", comments=" + comments +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void addComment(Comment comment) {
        comments.add(comment);

    }
}
