package school.faang.task_58140;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserAction {
    private final int id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
