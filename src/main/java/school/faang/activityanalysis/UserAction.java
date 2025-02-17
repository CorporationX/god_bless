package school.faang.activityanalysis;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAction {
    private final int id;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
