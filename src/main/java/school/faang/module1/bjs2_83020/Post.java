package school.faang.module1.bjs2_83020;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@ToString
@Getter
public class Post {
    private static final AtomicInteger COUNTER = new AtomicInteger();
    private final int id = COUNTER.incrementAndGet();
    private final String title;
    private final String content;
    private final String author;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    private final List<Comment> comments = new CopyOnWriteArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public boolean removeComment(Comment comment) {
        return comments.remove(comment);
    }
}