package faang.school.godbless.BJS2_22564;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {
    private long userId;
    private String userName;
    private LocalDateTime actionDate;
    private String content;
    private ActionType actionType;
}
