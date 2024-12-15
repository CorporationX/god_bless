package school.faang.task_47239;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}