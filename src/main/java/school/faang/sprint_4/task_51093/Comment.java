package school.faang.sprint_4.task_51093;

import lombok.NonNull;

import java.time.LocalDateTime;

public record Comment(@NonNull String text,
                      @NonNull String author,
                      @NonNull LocalDateTime timestamp) {
}
