package school.faang.userActivity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAction {
    private final int id;
    private final String name;
    private final String actionType;
    private final LocalDate actionDate;
    private final String content;
}
