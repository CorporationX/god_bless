package school.faang.sprint2.task_BJS2_58200;

import java.time.LocalDate;

public record UserAction(
        int id,
        String name,
        ActionType actionType,
        LocalDate actionDate,
        String content
) {}
