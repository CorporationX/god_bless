package school.faang.naughtwoBJS258208;

import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserAction {
    int id;
    String name;
    ActionType actionType;
    LocalDate actionDate;
    String content;

    public UserAction(int id, @NonNull String name, ActionType actionType,
                      LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}
