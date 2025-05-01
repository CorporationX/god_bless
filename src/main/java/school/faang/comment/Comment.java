package school.faang.comment;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private int id;
    private String text;
    private String author;
    private LocalDateTime timestamp;

    public Comment(int id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }
}
