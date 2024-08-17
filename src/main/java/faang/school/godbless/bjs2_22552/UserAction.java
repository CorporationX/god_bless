package faang.school.godbless.bjs2_22552;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String username;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
