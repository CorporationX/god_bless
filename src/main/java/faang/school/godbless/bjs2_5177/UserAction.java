package faang.school.godbless.bjs2_5177;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
