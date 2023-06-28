package faang.school.godbless.sprint2.activity;

public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String actionType;

    private ActionType(String type) {
        this.actionType = type;
    }


    public String getActionType() {
        return actionType;
    }

}
