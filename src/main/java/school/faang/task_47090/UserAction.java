package school.faang.task_47090;

import java.time.LocalDate;

public record UserAction(int id,
                         String name,
                         String type,
                         LocalDate date,
                         String content) {
}
