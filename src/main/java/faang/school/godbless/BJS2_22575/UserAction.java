package faang.school.godbless.BJS2_22575;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserAction {
    private Integer id;
    private String name;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
