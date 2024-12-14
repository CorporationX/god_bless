package school.faang.task47300;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@EqualsAndHashCode
@Setter
@Getter
@ToString
public class UserAction {
    private int id;
    private String name;
    private String action;
    private LocalDate actionDate;

    private String content;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActionType() {
        return action;
    }

    public LocalDate getActionDate() {
        return actionDate;
    }

    public String getContent() {
        return content;
    }

    public UserAction(int id, String name, String action, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.action = action;
        this.actionDate = actionDate;
        this.content = content;

    }
}

