package useractiv;

public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String value;

    ActionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ActionType fromString(String value) {
        for (ActionType action : ActionType.values()) {
            if (action.getValue().equalsIgnoreCase(value)) {
                return action;
            }
        }
        throw new IllegalArgumentException("Unknown action type: " + value);
    }
}
