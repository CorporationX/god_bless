package school.faang.useranalitics;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class UserAction {

    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(actionType, "Action type cannot be null");
        Objects.requireNonNull(actionDate, "Action date cannot be null");
        Objects.requireNonNull(content, "Content cannot be null");
        this.id = id;
        this.name = name;
        this.actionType = ActionType.valueOf(actionType.toUpperCase());
        this.actionDate = actionDate;
        this.content = content;
    }

    public enum ActionType {
        POST, COMMENT, LIKE, SHARE
    }

    public void setName(String name) {
        Objects.requireNonNull(name, "Name cannot be null");
        this.name = name;
    }

    public void setActionType(String actionType) {
        this.actionType = ActionType.valueOf(actionType);
    }

    public void setActionDate(LocalDate actionDate) {
        Objects.requireNonNull(actionDate, "Action date cannot be null");
        this.actionDate = actionDate;
    }

    public void setContent(String content) {
        Objects.requireNonNull(content, "Content cannot be null");
        this.content = content;
    }
}
