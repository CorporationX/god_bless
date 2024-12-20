package school.faang.task_47477;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {

    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
