package school.faang.bjs2_88130.user_action;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
public class UserAction {
    private final int userId;
    private final String userName;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;

    public UserAction(int userId, String userName, ActionType action, LocalDate actionDate, String content) {
        this.userId = userId;
        this.userName = userName;
        this.actionType = action;
        this.actionDate = actionDate;
        this.content = content;
    }

    public enum ActionType {
        POST,
        COMMENT,
        LIKE,
        SHARE
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserAction userAction = (UserAction) o;
        return userId == userAction.userId && userName.equals(userAction.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}
