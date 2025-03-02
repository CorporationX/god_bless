package school.faang.task_62589;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;
}
