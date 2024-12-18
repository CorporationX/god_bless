package school.faang.activity_analysis;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate localDate, String content) {
}
