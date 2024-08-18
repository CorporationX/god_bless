package faang.school.godbless.BJS2_22575;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ActionType {
    POST("post"), COMMENT("comment"), LIKE("like"), SHARE("share");

    private final String type;
}
