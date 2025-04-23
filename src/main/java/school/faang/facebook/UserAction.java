package school.faang.facebook;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private final int userId;
    private final String userName;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}