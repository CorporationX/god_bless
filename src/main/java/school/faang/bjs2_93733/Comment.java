package school.faang.bjs2_93733;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Comment {
    private final String text;
    private final String author;
    private LocalDateTime timestamp;

    public Comment(String author, String text) {
        this.author = author;
        this.text = text;
    }
}
