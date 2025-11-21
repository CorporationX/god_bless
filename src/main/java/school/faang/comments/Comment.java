package school.faang.comments;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
public class Comment {
    private final String text;
    private final User author;
    private final LocalDateTime timestamp;
}
