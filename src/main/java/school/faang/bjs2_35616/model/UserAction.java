package school.faang.bjs2_35616.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class UserAction {
    private final int userId;
    private final String userName;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
