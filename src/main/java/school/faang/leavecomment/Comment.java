package school.faang.leavecomment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class Comment {
    private final int id;
    private final String author;
    private final LocalDateTime timestamp;
    private String text;
}
