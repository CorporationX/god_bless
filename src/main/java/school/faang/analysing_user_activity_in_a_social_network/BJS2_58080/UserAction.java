package school.faang.analysing_user_activity_in_a_social_network.BJS2_58080;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserAction {
    private final int id;
    private final String name;
    private ActionType actionType;
    private LocalDate localDate;
    private String content;

    public UserAction(int id, String name, ActionType actionType, LocalDate localDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.localDate = localDate;
        this.content = content;
    }
}
