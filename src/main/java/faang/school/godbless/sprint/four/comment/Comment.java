package faang.school.godbless.sprint.four.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Comment {
    private final long id;
    private final long userId;
    private String text;
    private LocalDateTime dateTime;

}
