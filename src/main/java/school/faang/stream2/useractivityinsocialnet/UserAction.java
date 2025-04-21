package school.faang.stream2.useractivityinsocialnet;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserAction {
    private final Integer userID;
    private String name;
    private final ActionType actionType;
    private LocalDate actionDate;
    private final String content;
    private final UsersByID users;

    public UserAction(UsersByID users, Integer id, ActionType actionType, String content) {
        this.users = users;
        this.userID = id;
        name = users.getUsers().get(id).getName();
        this.actionType = actionType;
        actionDate = LocalDate.now();
        this.content = content;
    }
}
