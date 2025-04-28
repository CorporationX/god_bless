package school.faang.activityanalysis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private long id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
