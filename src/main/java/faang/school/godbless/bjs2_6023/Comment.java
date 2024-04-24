package faang.school.godbless.bjs2_6023;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class Comment {
    private long id;
    private String text;
    private String author;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Comment(long id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }
}
