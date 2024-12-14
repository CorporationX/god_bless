package school.faang.task_47144;

import lombok.Getter;

@Getter
public enum ActionType {
    COMMENT("comment"),
    POST("post"),
    LIKE("like"),
    SHARE("share");

    private final String actionName;

    ActionType(String actionName) {
        this.actionName = actionName;
    }
}
