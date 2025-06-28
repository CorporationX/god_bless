package school.faang.commentator;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    private String text;
    private String author;
    private LocalDateTime timestamp;
}
