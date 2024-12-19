package school.faang.sprint_2.task_47076;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
