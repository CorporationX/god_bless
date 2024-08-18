package faang.school.godbless.BJS2_22563;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Getter
public class UserAction {
    private User user;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
