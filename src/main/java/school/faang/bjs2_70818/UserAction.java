package school.faang.bjs2_70818;

import java.time.LocalDate;

public record UserAction(
    Integer id,
    String name,
    ActionType actionType,
    LocalDate actionDate,
    String content
) {
}
