package school.faang.task47300;

public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");
    private final String actionType;

    ActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getActionType() {
        return actionType;
    }

}
