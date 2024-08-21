package streamapi.three;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserAction {
    private int userId;
    private String userName;
    private String actionType;
    private LocalDateTime actionDate;
    private String content;

    public UserAction(int userId, String userName, String actionType, String content) {
        this.userId = userId;
        this.userName = userName;
        this.actionType = actionType;
        this.actionDate = LocalDateTime.now();
        this.content = content;
    }
}
