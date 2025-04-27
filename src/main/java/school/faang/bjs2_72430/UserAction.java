package school.faang.bjs2_72430;

import java.time.LocalDate;

public record UserAction(User user, ActionType actionType, LocalDate actionDate, String content) {
}
