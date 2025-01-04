package school.faang.task_51213;

import java.time.LocalDateTime;

public record Comment(long id, String text, String author, LocalDateTime timestamp) {
}
