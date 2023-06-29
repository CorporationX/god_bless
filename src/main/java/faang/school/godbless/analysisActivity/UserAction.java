package faang.school.godbless.analysisActivity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String userName;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
