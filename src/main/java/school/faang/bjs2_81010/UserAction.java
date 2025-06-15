package school.faang.bjs2_81010;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(exclude = {"actionType", "actionDate", "content"})
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
