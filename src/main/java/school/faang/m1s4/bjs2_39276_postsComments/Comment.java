package school.faang.m1s4.bjs2_39276_postsComments;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;


@Getter
public class Comment {
    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    private final int id;
    private String text;
    private final String userName;
    private final LocalDateTime timestamp = LocalDateTime.now();

    public Comment(String text, String userName) {
        this.text = text;
        this.userName = userName;
        id = ID_COUNTER.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "timestamp=" + timestamp +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
