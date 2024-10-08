package school.faang.user.action.analyzer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private final Integer id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
