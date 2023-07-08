package faang.school.godbless.kxnvg.facebookcoments;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class Comment {

    private String text;
    private LocalDateTime dateTime;
    private User author;

    public Comment(String text, User author) {
        this.text = text;
        this.author = author;
        dateTime = LocalDateTime.now();
    }
}
