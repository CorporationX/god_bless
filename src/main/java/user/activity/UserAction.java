package user.activity;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
public class UserAction {
    private final int userId;
    @NonNull
    private final String userName;
    private final ActionType actionType;
    @NonNull
    private final LocalDateTime actionDate;
    @NonNull
    private final String content;
}
