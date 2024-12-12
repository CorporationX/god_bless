package school.faang.task47250;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActionType {
    POST("post"),
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String name;
}
