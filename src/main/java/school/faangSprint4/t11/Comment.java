package school.faangSprint4.t11;

import lombok.Data;

import java.time.LocalDateTime;

@Data
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