package faang.school.godbless.userBehaviorAnalysis;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private String actionDate;
    private String content;
}
