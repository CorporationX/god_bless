package school.faang.sprint_4.task_51901;

import java.time.LocalDateTime;

public record Comment(int id, String text, String author, LocalDateTime timestamp) {
}
