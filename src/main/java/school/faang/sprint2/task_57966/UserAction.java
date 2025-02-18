package school.faang.sprint2.task_57966;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private final int id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
