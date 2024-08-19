package faang.school.godbless.modul2.useractivity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserAction {
    private Long userId;
    private String userName;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
