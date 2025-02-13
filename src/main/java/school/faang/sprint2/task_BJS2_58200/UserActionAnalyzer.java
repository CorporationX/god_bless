package school.faang.sprint2.task_BJS2_58200;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final int MAX_PERCENT = 100;

    public List<Integer> getTopMostActiveUsers(List<UserAction> actions, int limit) {
        return getKeySortByValue(limit, actions.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(UserAction::getId)));
    }

    public List<String> getTopMostPopularTopics(List<UserAction> actions, int limit) {
        Pattern pattern = Pattern.compile("\\B#\\w+");

        return getKeySortByValue(limit, actions.stream()
                .filter(Objects::nonNull)
                .filter(action -> action.getContent().contains("#"))
                .collect(Collectors.groupingBy(action -> {
                    Matcher matcher = pattern.matcher(action.getContent());
                    matcher.find();
                    return matcher.group();

                })));
    }

    public List<Integer> getUsersByMostCommentsInMonth(List<UserAction> actions, int limit) {
        LocalDate last = LocalDate.now().minusMonths(1);

        return getKeySortByValue(limit, actions.stream()
                .filter(Objects::nonNull)
                .filter(action -> action.getActionDate().isAfter(last))
                .collect(Collectors.groupingBy(UserAction::getId)));
    }

    public Map<ActionType, Double> getActionTypePercent(List<UserAction> actions) {
        Map<ActionType, Double> actionTypePercent = new HashMap<>();

        fillTypePercent(actionTypePercent, actions, ActionType.POST);
        fillTypePercent(actionTypePercent, actions, ActionType.LIKE);
        fillTypePercent(actionTypePercent, actions, ActionType.COMMENT);
        fillTypePercent(actionTypePercent, actions, ActionType.SHARE);

        return actionTypePercent;
    }

    private void fillTypePercent(Map<ActionType, Double> types, List<UserAction> actions, ActionType type) {
        double typePartOfActions =  (double) actions.size() / actions.stream()
                .filter(Objects::nonNull)
                .map(UserAction::getActionType)
                .filter(actionType -> actionType == type)
                .count();
        double typePercent = typePartOfActions == Double.POSITIVE_INFINITY ? 0.0 : MAX_PERCENT / typePartOfActions;
        types.put(type, typePercent);
    }

    private <T> List<T> getKeySortByValue(int limit, Map<T, List<UserAction>> actions) {
        return actions.entrySet().stream()
                .sorted((entry1, entry2)
                        -> entry2.getValue().size() - entry1.getValue().size())
                .map(Map.Entry::getKey)
                .limit(limit).toList();
    }
}