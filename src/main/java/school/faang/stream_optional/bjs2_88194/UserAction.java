package school.faang.stream_optional.bjs2_88194;

import java.time.LocalDate;

public record UserAction(
        int userId,
        String userName,
        ActionType actionType,
        LocalDate actionDate,
        String content
) {
}