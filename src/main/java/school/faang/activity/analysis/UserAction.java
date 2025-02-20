package school.faang.activity.analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private final int id;
    private final String name;
    private ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
