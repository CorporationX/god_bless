package school.faang.bjs247359;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@ToString
public class UserAction {
    private static int ID_COUNTER;
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(String name, String actionType, LocalDate actionDate, String content) {
        this.id = ++ID_COUNTER;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        if (Objects.equals(actionType, "like") || Objects.equals(actionType, "share")) {
            this.content = "' '";
        } else {
            this.content = content;
        }
    }
}
