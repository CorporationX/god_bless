package faang.school.godbless.leave_comments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class Comment {
    private String author;
    private String text;
    private LocalDateTime dateTime;
}
