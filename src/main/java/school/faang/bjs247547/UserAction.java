package school.faang.bjs247547;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserAction {

    protected Integer id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(Integer id, String name, String actionTypeString, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = ActionType.valueOf(actionTypeString.toUpperCase()); // Convert to uppercase
        this.actionDate = actionDate;
        this.content = content;
    }

}
