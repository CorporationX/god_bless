package school.faang.bjs2_81019;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private long userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
