package school.faang.useractivityanalysis;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class UserAction {
    private final int id;
    private final String name;
    private final ActionType actionType ;
    private final LocalDate actionDate ;
    private final String content ;
}
