package Social;

import java.time.LocalDate;

public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
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

    public String getActionType() {
        return actionType;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public String getContent() {
        return content;
    }
}
