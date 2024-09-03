package faang.school.godbless.sprint4.facebook;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class Comment {
    private final long id;
    private String text;
    private User author;
    private final LocalDateTime dateTime = LocalDateTime.now();
}
