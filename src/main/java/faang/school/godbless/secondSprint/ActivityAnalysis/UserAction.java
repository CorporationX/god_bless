package faang.school.godbless.secondSprint.ActivityAnalysis;

import lombok.Value;

import java.time.LocalDate;

@Value
public class UserAction {
    int userId;
    String userName;
    ActionType actionType;
    LocalDate actionDate;
    String content;
}
