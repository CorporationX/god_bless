package BJS258102;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate date;
    private String content;

    public UserAction(Integer id, String name, ActionType actionType, LocalDate date, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.date = date;
        this.content = content;
    }

}
