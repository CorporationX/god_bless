package faang.school.godbless.useractives;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserAction {
    private int userId;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;

    public UserAction(int userId, ActionType actionType, LocalDateTime actionDate, String content) {
        this.userId = userId;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

    public UserAction(int userId, ActionType actionType, LocalDateTime actionDate) {
        this.userId = userId;
        this.actionType = actionType;
        this.actionDate = actionDate;
    }
}
