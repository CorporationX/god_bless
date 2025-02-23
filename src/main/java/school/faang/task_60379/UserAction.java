package school.faang.task_60379;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@ToString
@Getter
public class UserAction {
    private final int userId;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
