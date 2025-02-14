package school.faang;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserAction {
    private final int id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;

    public UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
        validateName(name);
        validateContent(content);
        validateActionType(actionType);
        validateActionDate(actionDate);

        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name can't be null or empty. Provided value: " + name);
        }
    }

    private void validateContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("The content can't be null.");
        }
    }

    private void validateActionType(ActionType actionType) {
        if (actionType == null) {
            throw new IllegalArgumentException("The actionType can't be null or empty.");
        }
    }

    private void validateActionDate(LocalDate actionDate) {
        if (actionDate == null) {
            throw new IllegalArgumentException("The actionDate can't be null or empty.");
        }
    }
}
