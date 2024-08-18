package faang.school.godbless.analitic;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class UserAction {
    private final Integer id;
    private final String name;
    private final ActionType actionType;
    private final Date actionDate;
    private final String content;

    public UserAction(Integer id, String name, ActionType actionType, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.content = content;
        actionDate = new Date();
    }
}
