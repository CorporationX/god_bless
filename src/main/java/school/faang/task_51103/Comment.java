package school.faang.task_51103;

import lombok.Getter;
import school.faang.exception.CheckException;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;

    public Comment(String text, String author, LocalDateTime timestamp) {
        if (text == null || text.isEmpty()) {
            throw new CheckException("text");
        }
        if (author == null || author.isEmpty()) {
            throw new CheckException("author");
        }
        if (timestamp == null) {
            throw new CheckException("timestamp");
        }

        this.text = text;
        this.author = author;
        this.timestamp = timestamp;
    }
}
