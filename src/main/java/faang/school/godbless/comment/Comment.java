package faang.school.godbless.comment;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
public class Comment {
    private final String text;
    private final LocalDateTime dateTime;
    private final String author;

    public Comment(String text, String author) {
        this.text = text;
        this.author = author;
        this.dateTime = LocalDateTime.now();
    }
}
