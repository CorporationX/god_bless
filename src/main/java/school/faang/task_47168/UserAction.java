package school.faang.task_47168;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@ToString
public class UserAction {
    private final int id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate date;
    private final String content;
}