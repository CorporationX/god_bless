package school.faang.traffic_analysis;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
}
