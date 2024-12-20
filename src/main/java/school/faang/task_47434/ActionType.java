package school.faang.task_47434;

import lombok.Getter;

@Getter
public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String type;

    ActionType(String type) {
        this.type = type;
    }

    public static ActionType fromString(String type) {
        for (ActionType actionType : ActionType.values()) {
            if (actionType.type.equalsIgnoreCase(type)) {
                return actionType;
            }
        }
        throw new IllegalArgumentException("Unknown action type: " + type);
    }
}
