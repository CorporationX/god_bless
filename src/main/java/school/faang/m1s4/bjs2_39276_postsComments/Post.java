package school.faang.m1s4.bjs2_39276_postsComments;

import lombok.Getter;
import lombok.ToString;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ToString
@Getter
public class Post {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    private final int id;
    private final String title;
    private final String content;
    private final String author;
    private final Map<Integer, Comment> comments = new ConcurrentHashMap<>();

    public Post(String content, String author, String title) {
        this.content = content;
        this.author = author;
        this.title = title;
        id = ID_COUNTER.incrementAndGet();
    }

    public void addComment(Comment comment) {
        comments.put(comment.getId(), comment);
    }
}
