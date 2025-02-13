package school.faang.sprint2.task_BJS2_58200;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final int MAX_PERCENT = 100;
    private static final Pattern TOPIC_PATTERN = Pattern.compile("\\B#\\w+");
    private static final LocalDate LAST_MONTH = LocalDate.now().minusMonths(1);

    private final Function<UserAction, String> actionTopic = action -> {
        Matcher matcher = TOPIC_PATTERN.matcher(action.getContent());
        if (matcher.find()) {
            return matcher.group();
        } else {
            throw new RuntimeException("топика не найдено");
        }
    };

    public List<Integer> getTopMostActiveUsers(List<UserAction> actions, int limit) {
        Map<Integer, List<UserAction>> userWithActions = actions.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(UserAction::getId));
        return getKeysSortByValue(userWithActions, limit);
    }

    public List<String> getTopMostPopularTopics(List<UserAction> actions, int limit) {
        Map<String, List<UserAction>> topicWithActions = actions.stream()
                .filter(Objects::nonNull)
                .filter(action -> action.getContent().contains("#"))
                .collect(Collectors.groupingBy(actionTopic));
        return getKeysSortByValue(topicWithActions, limit);
    }

    public List<Integer> getUsersByMostCommentsInMonth(List<UserAction> actions, int limit) {
        Map<Integer, List<UserAction>> userWithActions = actions.stream()
                .filter(Objects::nonNull)
                .filter(action -> action.getActionDate().isAfter(LAST_MONTH))
                .collect(Collectors.groupingBy(UserAction::getId));
        return getKeysSortByValue(userWithActions, limit);
    }

    public Map<ActionType, Double> getActionTypePercent(List<UserAction> actions) {
        Map<ActionType, Double> actionTypePercent = new HashMap<>();
        Arrays.stream(ActionType.values())
                .forEach(type -> fillActionTypePercent(actionTypePercent, actions, type));
        return actionTypePercent;
    }

    private void fillActionTypePercent(Map<ActionType, Double> types, List<UserAction> actions, ActionType type) {
        double typePartOfActions =  (double) actions.size() / actions.stream()
                .filter(Objects::nonNull)
                .map(UserAction::getActionType)
                .filter(actionType -> actionType == type)
                .count();

        double typePercent = typePartOfActions == Double.POSITIVE_INFINITY ? 0.0 : MAX_PERCENT / typePartOfActions;
        types.put(type, typePercent);
    }

    private <T> List<T> getKeysSortByValue(Map<T, List<UserAction>> actions, int limit) {
        return actions.entrySet().stream()
                .sorted(Collections.reverseOrder(Comparator.comparingInt(entry -> entry.getValue().size())))
                .map(Map.Entry::getKey)
                .limit(limit).toList();
    }
}