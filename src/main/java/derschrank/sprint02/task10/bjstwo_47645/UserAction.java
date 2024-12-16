package derschrank.sprint02.task10.bjstwo_47645;

import java.time.LocalDate;

public record UserAction(
        int id,
        String name,
        String actionType,
        LocalDate actionDate,
        String content
) {
}
