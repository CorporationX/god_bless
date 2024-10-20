package school.faang.streamapi2;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

}


