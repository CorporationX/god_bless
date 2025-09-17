package school.faang.bjs2_88175;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
