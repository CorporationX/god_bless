package school.faang;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate date;
    private String content;

    public UserAction(int id, String name, ActionType actionType, LocalDate date, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.date = date;
        this.content = content;
    }

    public enum ActionType {
        POST,
        COMMENT,
        LIKE,
        SHARE
    }
}