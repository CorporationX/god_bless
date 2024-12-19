package derschrank.sprint02.task10.bjstwo_47645;

import java.time.LocalDate;

public record UserAction(
        int id,
        String name,
        String actionType,
        LocalDate actionDate,
        String content
) {
    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        validationUserAction();

        this.content = content;
    }

    private void validationUserAction() {
        if (id == 0 || name == null || actionType() == null || actionDate() == null) {
            throw new IllegalArgumentException("UserAction has wrong field(s)");
        }
    }
}
