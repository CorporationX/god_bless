package school.faang.bjs2_88229;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDate;

@ToString
@Getter
@AllArgsConstructor
public class UserAction {

    private final int userId;
    private final String userName;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
