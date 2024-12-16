package school.faang.task_47107;

import lombok.Getter;
import school.faang.task_47107.exception.CheckException;

import java.time.LocalDate;

@Getter
public class UserAction {
    private final int id;
    private final String name;
    private final String actionType;
    private final LocalDate actionDate;
    private final String content;

    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
        if (name == null) {
            throw new CheckException("name");
        }
        if (actionType == null) {
            throw new CheckException("actionType");
        }
        if (actionDate == null) {
            throw new CheckException("actionDate");
        }
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}
