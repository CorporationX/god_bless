package school.faang.analysuseractivsocnetbjs47403;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum ActionType {
    COMMENT("comment"),
    LIKE("like"),
    SHARE("share");

    private final String type;
}
