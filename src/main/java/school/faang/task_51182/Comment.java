package school.faang.task_51182;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
@ToString
public class Comment {
    private final UUID id = UUID.randomUUID();
    private final String text;
    private final User author;
    private final LocalDateTime timestamp;
}
