package school.faang.task_47207;

import java.time.LocalDate;

public record UserAction(User user, ActionType actionType, LocalDate actionDate, String content) {
}
