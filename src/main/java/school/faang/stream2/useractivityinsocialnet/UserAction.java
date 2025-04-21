package school.faang.stream2.useractivityinsocialnet;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAction {
    private final Integer userId;
    private final String name;
    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;
}
