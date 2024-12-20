package school.faang.task_47434;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@EqualsAndHashCode
public class UserAction {

    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}
