package faang.school.godbless.task.lambda.analitics.of.users.activity;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserAction {
    private final long id;
    private final String name;
    private final ActionType actionType;
    private final LocalDateTime actionDate;
    private final String content;

    public UserAction(long id, String name, ActionType actionType, LocalDateTime actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}
