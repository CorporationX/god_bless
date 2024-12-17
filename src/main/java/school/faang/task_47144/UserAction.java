package school.faang.task_47144;

import java.time.LocalDate;

public record UserAction(int userId,
                         String name,
                         ActionType actionType,
                         LocalDate actionDate,
                         String content) {
}