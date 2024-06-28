package faang.school.godbless.leaving_comments;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@AllArgsConstructor
public class Comment {
    private String message;
    private LocalDateTime dateTime;
    private String author;
}
