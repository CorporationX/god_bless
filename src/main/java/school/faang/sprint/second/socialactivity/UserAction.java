package school.faang.sprint.second.socialactivity;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class UserAction {
    private final int id;
    @NonNull
    private final String name;
    @NonNull
    private final ActionType actionType;
    @NonNull
    private final LocalDate actionDate;
    @NonNull
    private final String content;

    public UserAction(int id,
                      @NonNull String name,
                      @NonNull ActionType actionType,
                      @NonNull LocalDate actionDate,
                      @NonNull String content
    ) {
        validateInputData(name);
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

    private void validateInputData(@NonNull String name) {
        if (name.isBlank()) {
            throw new UsernameBlankException("Name cannot be blank");
        }
    }
}
