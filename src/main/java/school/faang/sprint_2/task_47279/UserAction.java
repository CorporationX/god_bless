package school.faang.sprint_2.task_47279;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
}
