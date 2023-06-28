package faang.school.godbless.lambda_stream.activity_analysis;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
public class UserAction {
    private int id;
    private String actionType;
    private LocalDateTime actionDate;
    private String content;
    private static final String[] validActionTypes = {"post", "comment", "like"};

    public UserAction(int id, String actionType, LocalDateTime actionDate, String content) {
        validation(id, actionType, actionDate, content);
        this.id = id;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

    private void validation(int id, String actionType, @NonNull LocalDateTime actionDate, String content) {
        if (id < 0 || actionType.isBlank() || actionDate.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException();
        }
        boolean isLikeAction = actionType.equalsIgnoreCase("like");
        boolean isValidActionType = false;
        for (String validAction : validActionTypes) {
            if (actionType.equalsIgnoreCase(validAction)) {
                isValidActionType = true;
                break;
            }
        }
        if (isLikeAction) {
            this.content = null;
        } else if (!content.isBlank() && isValidActionType) {
            this.content = content;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
