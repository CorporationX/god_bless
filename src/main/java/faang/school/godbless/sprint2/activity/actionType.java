package faang.school.godbless.sprint2.activity;

public enum actionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String actionType;

    private actionType(String type) {
        this.actionType = type;
    }


    public String getActionType() {
        return actionType;
    }

}
