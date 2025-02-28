package school.faang.task_62690;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Comment {
    private String author;
    private String text;
    private LocalDateTime timestamp;
}
