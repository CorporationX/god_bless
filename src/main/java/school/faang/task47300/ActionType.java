package school.faang.task47300;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public enum ActionType {
    POST,
    COMMENT,
    LIKE,
    SHARE

}
