package faang.school.godbless.user_activity_analysis;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String username;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}