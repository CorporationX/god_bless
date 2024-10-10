package school.faang.analyze_users_activity_BJS2_35381;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserAction {
    private int id;
    private String name;
    private String actionType;
    private LocalDate actionDate;
    private String content;
}
