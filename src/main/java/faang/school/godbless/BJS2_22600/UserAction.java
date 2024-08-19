package faang.school.godbless.BJS2_22600;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class UserAction {
    private long id;
    private String name;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
