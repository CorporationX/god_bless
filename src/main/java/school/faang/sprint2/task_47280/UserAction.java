package school.faang.sprint2.task_47280;

import lombok.NonNull;
import java.time.LocalDate;

public record UserAction(long id, @NonNull String name, @NonNull ActionType actionType,
                         @NonNull LocalDate actionDate, String content) {
}
