package school.faang.sprint_2.user_analysis_in_sm;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private Integer id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
