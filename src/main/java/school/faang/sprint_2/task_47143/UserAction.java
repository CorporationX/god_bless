package school.faang.sprint_2.task_47143;

import lombok.NonNull;

import java.time.LocalDate;

public record UserAction(int id,
                         @NonNull String name,
                         @NonNull ActionType actionType,
                         @NonNull LocalDate actionDate,
                         @NonNull String content) {
}
