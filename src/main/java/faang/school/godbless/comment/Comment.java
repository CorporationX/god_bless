package faang.school.godbless.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    private String author;
    private String text;
    private LocalDateTime time;
}
