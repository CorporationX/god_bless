package faang.school.godbless.stream_api.task3activ_user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDateTime actionDate;
    private String content;
    private static int countId;

    public UserAction(String name, String actionType, String content) {
        this.id = ++countId;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = LocalDateTime.now();
        this.content = content;
    }
}
