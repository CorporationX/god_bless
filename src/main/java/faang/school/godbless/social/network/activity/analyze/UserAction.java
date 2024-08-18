package faang.school.godbless.social.network.activity.analyze;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {
    private Integer id;
    private String name;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
