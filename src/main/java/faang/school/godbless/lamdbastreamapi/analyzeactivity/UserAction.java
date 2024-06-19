package faang.school.godbless.lamdbastreamapi.analyzeactivity;

import java.time.LocalDate;

public record UserAction(int id, String name, String actionType, LocalDate date, String content) {
}
