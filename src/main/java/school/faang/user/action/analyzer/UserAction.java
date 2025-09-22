package school.faang.user.action.analyzer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
public class UserAction {

    private final Integer userId;
    private final String username;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;

}
