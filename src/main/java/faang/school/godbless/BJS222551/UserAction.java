package faang.school.godbless.BJS222551;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserAction {
    private final long userId;
    private String userName;
    private final ActionType actionType;
    private final LocalDateTime actionDate;
    private final String content;
}
