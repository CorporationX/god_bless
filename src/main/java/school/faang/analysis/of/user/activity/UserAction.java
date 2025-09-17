package school.faang.analysis.of.user.activity;

import java.time.LocalDate;

public record UserAction(Integer userId, String userName, ActionType actionType, LocalDate actionDate, String content) {
}