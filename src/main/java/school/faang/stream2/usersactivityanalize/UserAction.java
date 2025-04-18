package school.faang.stream2.usersactivityanalize;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class UserAction {
    private final int id;

    private final String name;

    private final ActionType actionType;

    private final LocalDate actionDate;

    private final String content;
}
