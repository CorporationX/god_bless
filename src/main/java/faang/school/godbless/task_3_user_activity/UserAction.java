package faang.school.godbless.task_3_user_activity;

import java.time.LocalDate;

//public class UserAction {
//    private int userId;
//    private ActionType actionType;
//    private LocalDate actionDate;
//    private String content;
//}

public record UserAction(int id, ActionType actionType, LocalDate actionDate, String content) {
}
