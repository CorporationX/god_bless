package faang.school.godbless.analyzinguseractivity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {
    private String userId;
    private String userName;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}