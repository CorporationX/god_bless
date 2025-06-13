package school.faang.module1.bjs2_81044;

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