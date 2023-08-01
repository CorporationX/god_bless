package faang.school.godbless.analysisOfUserActivity;

public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String actionType;

    ActionType(String type) {
        this.actionType = type;
    }
}
