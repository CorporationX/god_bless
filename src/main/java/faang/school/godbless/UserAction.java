package faang.school.godbless;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserAction {
    private String id;
    private String name;
    private String content;
    private ActionType actionType;
    private LocalDateTime actionDate;
}
