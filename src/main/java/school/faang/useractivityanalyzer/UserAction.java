package school.faang.useractivityanalyzer;

import java.time.LocalDate;

public record UserAction(
        int id,
        String userName,
        ActionType actionType,
        LocalDate actionDate,
        String content) {}
