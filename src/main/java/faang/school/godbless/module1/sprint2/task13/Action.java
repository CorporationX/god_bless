package faang.school.godbless.module1.sprint2.task13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@Getter
public class Action {
    private ActionType actionType;
    private String content;
    private LocalDateTime actionCreateAt;
}
