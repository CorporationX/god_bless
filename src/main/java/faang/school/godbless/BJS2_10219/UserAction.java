package faang.school.godbless.BJS2_10219;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class UserAction {
    int userId;
    String name;
    ActionType actionType;
    LocalDateTime actionDate;
    String content;
}
