package school.faang.analyze_activity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {
    private Integer id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
