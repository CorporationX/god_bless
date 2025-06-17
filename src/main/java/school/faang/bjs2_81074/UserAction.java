package school.faang.bjs2_81074;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private ActionType actions;
    private LocalDate actionDate;
    private String content;
}
