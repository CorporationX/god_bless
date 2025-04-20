package school.faang.analayzer;

import java.time.LocalDate;

public record UserAction(int id, String name, ActionType actionType, LocalDate localDate, String content) {
}