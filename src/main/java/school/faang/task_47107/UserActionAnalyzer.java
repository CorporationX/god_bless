package school.faang.task_47107;

import school.faang.exception.CheckException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<String> topActiveUsers(List<UserAction> actions) {
        checkActions(actions);
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions) {
        checkActions(actions);
        return actions.stream()
                .filter(action -> action.getContent() != null
                        && !action.getContent().isEmpty()
                        && List.of("post", "comment").contains(action.getActionType()))
                .

    }

    private void checkActions(List<UserAction> actions) {
        if (actions == null) {
            throw new CheckException("actions");
        }
    }
}
