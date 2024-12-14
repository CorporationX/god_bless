package school.faang.task_47144;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@ToString
public class UserAction {
    private final int userId;
    private final String name;
    private final String actionType;
    private final LocalDate actionDate;
    private final String content;
}