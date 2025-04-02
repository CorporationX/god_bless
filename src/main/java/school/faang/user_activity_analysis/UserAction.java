package school.faang.user_activity_analysis;

import java.time.LocalDate;

public class UserAction {
    int id;
    String name;
    ActionType actionType;
    LocalDate actionDate;
    String content;

    public UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public String getContent() {
        return content;
    }
}
