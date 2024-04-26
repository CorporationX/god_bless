package faang.school.godbless.facebook;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class Comment {
    private int id;
    private String author;
    private String content;
    private LocalDateTime whenCreated;

    public Comment(int id, String author) {
        this.id = id;
        this.author = author;
        this.whenCreated = LocalDateTime.now();
    }
}
