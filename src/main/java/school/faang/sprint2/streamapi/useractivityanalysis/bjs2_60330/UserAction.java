package school.faang.sprint2.streamapi.useractivityanalysis.bjs2_60330;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private final long id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
