package analysisActivities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserAction {

    public enum UserActionType {
        POST, COMMENT, LIKE, SHARE
    }

    private final int id;
    private final String name;
    private final UserActionType type;
    private final LocalDate actionDate;
    private final String content;

    public UserAction(int id, String name, String type, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.type = UserActionType.valueOf(type);
        this.actionDate = actionDate;
        this.content = content;
    }
}
