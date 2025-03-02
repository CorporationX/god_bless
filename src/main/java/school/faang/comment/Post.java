package school.faang.comment;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Post {

    private static final AtomicInteger idGenerator = new AtomicInteger(0);

    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final List<Comment> comments;

    public Post(String title, String content, String author) {
        this.id = idGenerator.incrementAndGet();
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(String commentAuthor, LocalDateTime timestamp) {
        comments.removeIf(comment -> comment.getAuthor().equals(commentAuthor)
                && comment.getTimestamp().equals(timestamp));
    }
}
