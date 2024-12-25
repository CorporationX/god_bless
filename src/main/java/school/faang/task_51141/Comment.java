package school.faang.task_51141;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;
}