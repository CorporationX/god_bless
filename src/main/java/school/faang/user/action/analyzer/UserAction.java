package school.faang.user.action.analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private final Integer id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
