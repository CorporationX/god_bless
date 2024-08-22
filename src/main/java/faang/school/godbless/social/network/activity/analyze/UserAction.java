package faang.school.godbless.social.network.activity.analyze;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {
    private Integer userId;
    private String userName;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
