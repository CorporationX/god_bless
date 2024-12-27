package school.faang.task_51193;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class Comment {
    private final UUID id = UUID.randomUUID();
    private final String text;
    private final User author;
    private final LocalDateTime timestamp;
}
