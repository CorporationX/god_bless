package facebook;

import java.time.LocalDateTime;

public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;

    public Comment(String tekst, String author) {
        this.text = tekst;
        this.author = author;
        this.timestamp = LocalDateTime.now();
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "tekst='" + text + '\'' +
                ", author='" + author + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
