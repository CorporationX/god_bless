package faang.school.godbless.activityAnalysis;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(int userId, String userName, ActionType actionType, String content) {
        this.userId = userId;
        this.userName = userName;
        this.actionType = actionType;
        this.actionDate = LocalDate.now();
        this.content = content;
    }
}
