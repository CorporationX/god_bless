package school.faang.task_62690;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Comment {
    private final String author;
    private final String text;
    private final LocalDateTime timestamp;
}
