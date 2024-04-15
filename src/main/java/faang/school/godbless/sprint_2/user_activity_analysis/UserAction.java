package faang.school.godbless.sprint_2.user_activity_analysis;

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