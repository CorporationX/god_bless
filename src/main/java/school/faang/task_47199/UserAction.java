package school.faang.task_47199;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class UserAction {
    private final int id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
