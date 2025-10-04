package school.faang.m1.concurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;

    @Override
    public String toString() {
        return "Comment{" + author + " @ " + timestamp + ": " + text + "}";
    }
}
