package faang.school.godbless.activity_analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String content;
    private ActionType actionType;
    private Instant actionDate;
}
