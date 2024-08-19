package faang.school.godbless.user_activity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class UserAction {
    private final long id;
    private final String username;
    private final String content;
    private final ActionType actionType;
    private final LocalDate actionDate;
}
