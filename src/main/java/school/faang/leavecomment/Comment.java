package school.faang.leavecomment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;
}
