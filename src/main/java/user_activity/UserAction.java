package user_activity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String content;
    private ActionType actionType;
    private LocalDateTime actionDate;
}
