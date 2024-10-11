package school.faang.analysis;

import lombok.Getter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Getter
public class UserAction {
    private static final List<String> validActions = Arrays.asList("post", "comment", "like", "share");

    private final int id;
    private final String name;
    private final String actionType;
    private final LocalDate actionDate;
    private final String content;

    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
        if (!validActions.contains(actionType)) {
            throw new IllegalArgumentException("Invalid action type. Action must be post, comment, like or share.");
        }
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}
