package faang.school.godbless.sprint3.user_activity;

import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserAction {
    private int userId;
    private String username;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
