package school.faang.task_62589;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Comment {
    private final String text;
    private final String author;
    private final LocalDateTime timestamp;
}
