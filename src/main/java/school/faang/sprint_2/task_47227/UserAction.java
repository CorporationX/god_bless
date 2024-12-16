package school.faang.sprint_2.task_47227;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public record UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
    private static final List<String> VALID_ACTION = Arrays.asList("post", "comment", "like", "share");

    public UserAction(int id, String name, String actionType, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        if (!VALID_ACTION.contains(actionType)) {
            throw new IllegalArgumentException("possible meanings: " + VALID_ACTION);
        }
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }
}