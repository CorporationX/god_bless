package faang.school.godbless.comments;

import java.time.LocalDateTime;

public class Comment {
    private String text;
    private final String author;
    private LocalDateTime date = LocalDateTime.now();

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }
}
