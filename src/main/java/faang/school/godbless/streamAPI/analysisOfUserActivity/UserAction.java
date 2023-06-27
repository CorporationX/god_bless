package faang.school.godbless.streamAPI.analysisOfUserActivity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAction {
    private String id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;
}
