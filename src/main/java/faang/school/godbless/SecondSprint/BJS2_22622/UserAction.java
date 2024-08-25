package faang.school.godbless.SecondSprint.BJS2_22622;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class UserAction {
    private final String userName;
    private final String userID;
    private final String actionType;
    private final LocalDateTime actionDate;
    private final String content;

    public UserAction(User user, String content, String actionType) {
        userName = user.getName();
        userID = "#" + getUserID();
        actionDate = LocalDateTime.now();
        this.content = content;
        this.actionType = actionType;
    }
}
