package school.faang.task421.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        timestamp = LocalDateTime.now();
    }
}
