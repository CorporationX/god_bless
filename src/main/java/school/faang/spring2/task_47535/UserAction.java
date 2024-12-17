package school.faang.spring2.task_47535;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
