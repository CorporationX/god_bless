package school.faang.task_47258;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserAction {
    private final long id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;

    public UserAction(long id, String name, ActionType actionType, LocalDate actionDate, String content) {
        validateName(name);
        validateActionType(actionType);
        validateContent(content);
        validateActionDate(actionDate);

        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

    private static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can't be null or blank!");
        }
    }

    private static void validateActionType(ActionType actionType) {
        if (actionType == null) {
            throw new IllegalArgumentException("Action type can't be null!");
        }
    }

    private static void validateActionDate(LocalDate actionDate) {
        if (actionDate == null) {
            throw new IllegalArgumentException("Date can't be null!");
        }
    }

    private static void validateContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("Content can't be null!");
        }
    }
}
