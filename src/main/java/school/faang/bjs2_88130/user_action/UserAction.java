package school.faang.bjs2_88130.user_action;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = {"userId", "userName"})
public class UserAction {
    private final int userId;
    private final String userName;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;

    public enum ActionType {
        POST,
        COMMENT,
        LIKE,
        SHARE
    }
}
