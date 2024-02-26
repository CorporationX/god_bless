package faang.school.godbless.r_edzie.concurrency.comment;

import java.time.LocalDateTime;

public class Comment {
    private String text;
    private String author;
    private LocalDateTime dateTime;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.dateTime = LocalDateTime.now();
    }
}
