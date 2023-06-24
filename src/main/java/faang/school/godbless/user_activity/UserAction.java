package faang.school.godbless.user_activity;

import lombok.AllArgsConstructor;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserAction {

    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
