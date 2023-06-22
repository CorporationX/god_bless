package faang.school.godbless.kxnvg.analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class UserAction {

    private int id;
    private String name;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
