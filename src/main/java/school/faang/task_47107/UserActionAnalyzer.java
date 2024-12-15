package school.faang.task_47107;

import school.faang.exception.CheckException;

import java.util.List;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        if (actions == null) {
            throw new CheckException("actions");
        }
        return actions.stream().
    }
}
