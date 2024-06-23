package faang.school.godbless.task_3_user_activity;

import java.time.LocalDate;

public record UserAction(int id, ActionType actionType, LocalDate actionDate, String content) {
}
