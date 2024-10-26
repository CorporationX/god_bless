package dima.evseenko.comment;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private final int id;
    private final String author;
    private final LocalDateTime timestamp = LocalDateTime.now();

    private String text;

    public Comment(int id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }
}
