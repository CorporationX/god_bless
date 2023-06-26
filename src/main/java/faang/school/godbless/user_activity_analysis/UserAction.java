package faang.school.godbless.user_activity_analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@Getter
@Setter
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
