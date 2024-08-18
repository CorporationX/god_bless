package faang.school.godbless.AnalyzeSocialActivity;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserAction {
    private String userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(String userId, String userName, ActionType actionType, LocalDate actionDate, String content) {
        if (userId == null || userId.isEmpty() || userName == null || userName.isEmpty() || actionType == null || actionDate == null || content == null) {
            throw new IllegalArgumentException("Wrong parameters");
        }
        this.userId = userId;
        this.userName = userName;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}
