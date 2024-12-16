package school.faang.bjs_47153;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
        Map<Integer, Long> groupedCountsById = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserId, Collectors.counting()));

        Map<String, Long> groupedCountsByName = groupedCountsById.entrySet().stream()
                .limit(10)
                .collect(Collectors.toMap(
                        entry -> getUserNameById(actions, entry.getKey()),
                        Map.Entry::getValue)
                );
        return groupedCountsByName.keySet().stream()
                .toList();
    }

    public static List<String> topHashtags(List<UserAction> actions) {
        String reg = "#[a-zA-Z]*";
        Pattern pattern = Pattern.compile(reg);
        Map<String, Long> hashTagsCount = actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT
                        || action.getActionType() == ActionType.POST)
                .flatMap(action -> {
                    Matcher matcher = pattern.matcher(action.getContent());
                    return matcher.find() ? Stream.of(matcher.group()) : Stream.empty();
                })
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
                .collect(Collectors.groupingBy(
                        action -> action.getActionType().name(), Collectors.counting()
                ));

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
