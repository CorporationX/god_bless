package school.faang.sprint2.task_bjs247116;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@AllArgsConstructor
public class UserAction {
    private Integer id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
