package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserAction {
    String id;
    String name;
    ActionType actionType;
    LocalDateTime actionDate;
    String content;

    enum ActionType{
        POST,
        COMMENT,
        LIKE,
        SHARE,
    }
}
