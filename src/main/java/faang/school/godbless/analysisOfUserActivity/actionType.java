package faang.school.godbless.analysisOfUserActivity;

public enum actionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String actionType;

    actionType(String type) {
        this.actionType = type;
    }

    public String getActionType() {
        return actionType;
    }
}
