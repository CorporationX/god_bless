package school.faang.task_47156;

import lombok.NonNull;

import java.time.LocalDate;

public record UserAction(int userId, @NonNull String userName, @NonNull ActionType actionType,
                         @NonNull LocalDate actionDate, @NonNull String content) {
}
