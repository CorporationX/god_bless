package school.faang.task_47258;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserAction {
    private final Long id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;

    public UserAction(Long id, String name, ActionType actionType, LocalDate actionDate, String content) {
        Validator.validateName(name);
        Validator.validate(actionType);
        Validator.validate(actionDate);
        Validator.validate(content);

        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}
