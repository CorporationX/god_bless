package leave.comments;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Post {
    private final Long id = System.nanoTime();
    private final String title;
    private final String text;
    private final Author author;
    private volatile List<Comment> comments = new ArrayList<>();

    public Post(String header, String text, Author author) {
        this.title = header;
        this.text = text;
        this.author = author;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }
}
