package faang.school.godbless.stream.BJS2_5912;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private final int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
