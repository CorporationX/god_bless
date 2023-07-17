package faang.school.godbless.multithreading.leave_comment;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Comment {
    private final int id;
    private final String text;
    private final LocalDateTime time;
    private final Author author;

    public Comment(int id, String text, Author author) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.time = LocalDateTime.now();
    }
}
