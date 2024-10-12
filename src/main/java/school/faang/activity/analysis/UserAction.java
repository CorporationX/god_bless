package school.faang.activity.analysis;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private int userId;
    private String userName;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
