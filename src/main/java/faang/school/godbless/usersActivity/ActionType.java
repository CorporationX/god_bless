package faang.school.godbless.usersActivity;

public enum ActionType {
    POST ("post"),
    COMMENT ("comment"),
    LIKE ("like"),
    SHARE ("share");

    private String actionType;
    ActionType(String type){
        actionType = type;
    }

    public String getActionType() {
        return actionType;
    }
}
