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
}
