package school.faang.analysis_of_user_activity_in_the_social_network;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public final class UserAction {
    private final int id;
    private final String name;

    public enum ActionType {POST, COMMENT, LIKE, SHARE}

    private final ActionType actionType;
    private final LocalDate actionDate;
    private final String content;

    @java.beans.ConstructorProperties({"id", "name", "actionType", "actionDate", "content"})
    public UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
        this.id = id;
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.actionType = Objects.requireNonNull(actionType, "ActionType cannot be null");
        this.actionDate = Objects.requireNonNull(actionDate, "ActionDate cannot be null");
        this.content = content;
    }
}