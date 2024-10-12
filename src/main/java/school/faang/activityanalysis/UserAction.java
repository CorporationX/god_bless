package school.faang.activityanalysis;

import java.time.LocalDate;

public record UserAction(int id, String name, String actionType, LocalDate date, String content) {
}
