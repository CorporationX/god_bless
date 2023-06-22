package faang.school.godbless.AnalysisOfUserActivity;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate date, String content) {
}
