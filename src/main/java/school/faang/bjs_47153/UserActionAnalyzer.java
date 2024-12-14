package school.faang.bjs_47153;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<Integer, Long> groupedCountsById = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        return groupedCountsById.entrySet().stream()
                .collect(Collectors.toMap(entry -> getUserNameById(actions, entry.getKey()),
                        Map.Entry::getValue))
                .keySet()
                .stream().toList();
    }

    public static List<String> topHashtags(List<UserAction> actions) {

        Map<String, Long> hashTagsCount = actions.stream()
                .filter(action -> Objects.equals(action.getActionType(), (ActionType.COMMENT))
                        || Objects.equals(action.getActionType(), ActionType.POST))
                .flatMap(action ->
                        Arrays.stream(action.getContent().replaceAll("[,.!]?", "").split(" ")))
                .filter(s -> s.startsWith("#"))
                .collect(Collectors.groupingBy(hashTags -> hashTags, Collectors.counting()));

        return hashTagsCount.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        Map<Integer, Long> commentators = actions.stream()
                .filter(action -> Objects.equals(action.getActionType(), ActionType.COMMENT))
                .filter(action ->
                        LocalDate.now().minusMonths(1).isBefore(action.getActionDate()))
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        return commentators.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(3)
                .map(Map.Entry::getKey)
                .map(id -> getUserNameById(actions, id))
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        Map<String, Long> actionsByType = actions.stream()
                .collect(Collectors.groupingBy(action -> action.getActionType().name(),
                        Collectors.counting()));

        int actionsCount = actions.size();

        return actionsByType.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> entry.getValue() * 100.0 / actionsCount));
    }

    private static String getUserNameById(List<UserAction> actions, Integer userId) {
        Set<String> foundedUserNames = actions.stream()
                .filter(action -> Objects.equals(userId, action.getUserId()))
                .map(UserAction::getUserName)
                .collect(Collectors.toSet());

        if (foundedUserNames.size() != 1) {
            throw new UserNotFoundException("User " + userId + " not found");
        }

        return foundedUserNames.iterator().next();
    }

}
