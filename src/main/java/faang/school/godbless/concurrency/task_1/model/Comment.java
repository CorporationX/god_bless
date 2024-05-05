package faang.school.godbless.concurrency.task_1.model;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class Comment {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
    private String text;
    private final String dateTime = FORMATTER.format(LocalDateTime.now());
    private final User author;
    private final int postId;

    public Comment(String text, User author, int postId) {
        this.text = text;
        this.author = author;
        this.postId = postId;
    }
}