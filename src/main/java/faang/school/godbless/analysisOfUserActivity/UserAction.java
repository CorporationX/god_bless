package faang.school.godbless.analysisOfUserActivity;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
public class UserAction {
    private Integer id;
    private String user;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

//    public record UserAction(String id, String user, ActionType actionType, LocalDate actionDate, String content)
}
