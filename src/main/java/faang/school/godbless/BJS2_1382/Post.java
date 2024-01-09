package faang.school.godbless.BJS2_1382;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@AllArgsConstructor
public class Post {
    private static final AtomicInteger count = new AtomicInteger(1);
    private final int id;
    private String title;
    private String content;
    private User author;
    private List<Comment> comments;

    public Post(String title, String content, User author, List<Comment> comments) {
        this.id = count.getAndIncrement();
        this.title = title;
        this.content = content;
        this.author = author;
        this.comments = comments;
    }

    public synchronized void addComment (Comment comment) {
        comments.add(comment);
    }
}