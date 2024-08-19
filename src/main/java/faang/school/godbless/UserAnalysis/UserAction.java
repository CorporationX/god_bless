package faang.school.godbless.UserAnalysis;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private String content;
    private LocalDateTime actionDate;

    public UserAction(int id, String name, String actionType) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        actionDate = LocalDateTime.now();
    }

    public UserAction(int id, String name, String actionType, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.content = content;
        actionDate = LocalDateTime.now();
    }
}
