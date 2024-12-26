package school.faang.sprint4.task_51150;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@ToString
public class Comment {
    private final int id;
    private final String text;
    private final String author;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
