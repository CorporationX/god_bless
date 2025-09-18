package school.faang.bjs2_88175;

import java.time.LocalDate;

public record UserAction(
        int userId,
        String userName,
        ActionType actionType,
        LocalDate actionDate,
        String content
) {
}
