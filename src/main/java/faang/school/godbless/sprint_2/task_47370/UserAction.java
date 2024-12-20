package faang.school.godbless.sprint_2.task_47370;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private final LocalDate actionDate = LocalDate.now();
    private String content;
}
