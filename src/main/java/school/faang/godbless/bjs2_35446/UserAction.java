package school.faang.godbless.bjs2_35446;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate date;
    private String content;

    public static enum ActionType {
        POST, COMMENT, LIKE, SHARE
    }
}
