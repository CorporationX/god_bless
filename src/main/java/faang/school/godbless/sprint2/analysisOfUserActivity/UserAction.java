package faang.school.godbless.sprint2.analysisOfUserActivity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserAction {
    private User user;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content = "";

    public UserAction(User user, ActionType actionType, LocalDateTime actionDate) {
        this.user = user;
        this.actionType = actionType;
        this.actionDate = actionDate;
    }
}
