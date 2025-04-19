package school.faang.network;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class UserAction {
    private final int id;
    private final String name;
    private final ActionType type;
    private final LocalDate localDate;
    private final String comment;
}
