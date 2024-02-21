package faang.school.godbless.usersactivityanalysis2703;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDateTime actionDate;
    private String content;

    public UserAction(int id, String name, String actionType, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = LocalDateTime.now();
        this.content = content;
    }
}
