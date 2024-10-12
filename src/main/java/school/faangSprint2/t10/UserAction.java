package school.faangSprint2.t10;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserAction {
    private int userId;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(int userId, String name, String actionType, LocalDate actionDate, String content) {
        this.userId = userId;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}