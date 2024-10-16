package school.faang.BJS2_35530;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserAction {
    private final int id;
    private final String name;
    private final String actionType;
    private final LocalDate actionDate;
    private final String content;
}
