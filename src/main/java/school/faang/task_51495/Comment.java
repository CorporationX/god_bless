package school.faang.task_51495;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }
}
