package faang.school.godbless.leaveacomment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@EqualsAndHashCode(exclude = "timestamp")
@ToString
public class Comment {
    private final String text;
    private final LocalDateTime timestamp;
    private final String author;

    public Comment(String text, String author) {
        this.text = text;
        this.timestamp = LocalDateTime.now();
        this.author = author;
    }
}