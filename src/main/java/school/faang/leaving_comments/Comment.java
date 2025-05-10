package school.faang.leaving_comments;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class Comment {
    private final int id = GlobalIdGenerator.generateId(Comment.class);
    private final String text;
    private final String author;
    private final LocalDateTime timestamp = LocalDateTime.now();
}
