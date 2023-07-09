package faang.school.godbless.comment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
public class Comment {
    private static int counter;
    private int id = counter;
    private String text;
    private LocalDateTime localTime;
    private User author;

    public Comment(String text) {
        this.text = text;
        this.localTime = LocalDateTime.now();
        counter++;
    }
}
