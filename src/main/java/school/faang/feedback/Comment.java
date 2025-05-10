package school.faang.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
