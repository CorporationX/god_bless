package school.faang.bjs247099;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
}