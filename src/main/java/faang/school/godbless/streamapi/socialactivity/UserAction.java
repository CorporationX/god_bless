package faang.school.godbless.streamapi.socialactivity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {

    private final int userId;
    private final String userName;
    private final ActionType actionType;
    private final LocalDateTime actionDate;
    private final String content;

}
