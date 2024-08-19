package faang.school.godbless.BJS2_22565;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserAction {
    private final long userId;
    private final String name;
    private final String actionType;
    private final LocalDateTime actionDate;
    private final String content;
}
