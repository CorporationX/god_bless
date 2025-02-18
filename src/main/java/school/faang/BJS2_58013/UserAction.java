package school.faang.BJS2_58013;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class UserAction {

    private final int id;
    private final String name;
    private final ActionType type;
    private final LocalDate actionDate;
    private final String content;
}
