package faang.school.godbless.ActivityAnalys;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
