package faang.school.godbless.useractivity;


import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDateTime dateTime = LocalDateTime.now();
    private String content;

    public UserAction(int userId, String userName, ActionType actionType, String content) {
        this.userId = userId;
        this.userName = userName;
        this.actionType = actionType;
        this.content = content;
    }
}
