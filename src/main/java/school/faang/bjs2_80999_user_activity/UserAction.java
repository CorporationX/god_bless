package school.faang.bjs2_80999_user_activity;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
}
