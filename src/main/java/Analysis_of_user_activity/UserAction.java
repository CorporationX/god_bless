package Analysis_of_user_activity;

import java.time.LocalDate;

public class UserAction {
    private int userID;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public int getUserID() {
        return userID;
    }

    public String getContent() {
        return content;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }
}

enum ActionType {
    POST, COMMENT, LIKE, SHARE
}
