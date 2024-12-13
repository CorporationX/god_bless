package school.faang.sprint2.task_47174;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class UserAction {
    private final int id;
    private final String name;
    private final String actionType;
    private final LocalDate date;
    private final String text;
}
