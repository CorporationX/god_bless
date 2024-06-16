package faang.school.godbless.analysis_user_activity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private Action actionType;
    private LocalDate actionDate;
    private String content;
}
