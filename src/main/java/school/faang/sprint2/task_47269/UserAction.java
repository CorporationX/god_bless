package school.faang.sprint2.task_47269;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private final int id;
    private final String name;
    private final String actionType;
    private final LocalDate actionDate;
    private final String content;
}
