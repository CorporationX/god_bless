package bjs2_93615;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %s", timestamp, author, text);
    }
}