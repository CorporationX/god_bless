package school.faang.bjs_47153;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@ToString
public class UserAction {
    private final int userId;
    private final String userName;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
