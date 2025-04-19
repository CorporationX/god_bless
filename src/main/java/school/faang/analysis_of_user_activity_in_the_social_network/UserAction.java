package school.faang.analysis_of_user_activity_in_the_social_network;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserAction {

    private final int id;
    private final String name;

    public enum ActionType {POST, COMMENT, LIKE, SHARE}

    private final ActionType actionType;
    private LocalDate actionDate;
    private final String content;

}
