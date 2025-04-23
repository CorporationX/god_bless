package school.faang.sprint_2.user_analysis_in_sm;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class UserAction {
    private Integer id;
    private String name;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;
}
