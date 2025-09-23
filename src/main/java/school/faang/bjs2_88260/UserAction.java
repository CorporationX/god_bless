package school.faang.bjs2_88260;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class UserAction {
    private int userId;
    private String userName;
    private ActionType type;
    LocalDate actionDate;
    private String content;
}