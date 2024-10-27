package school.faang.comments;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private static int currentId = 0;

    private int id;
    private String text;
    private User author;
    private LocalDateTime timestamp;

    Comment(String text, User author) {
        this.id = ++currentId;
        this.text = text;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }
}
