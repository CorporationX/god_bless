package school.faang.bjs2_72133;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyser {

    private final int PERCENTAGE = 100;

    public List<String> filterTopByAppearance(Map<String, Long> stringsList, int top) {
        return stringsList.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(top)
                .toList();
    }

    public List<String> topActiveUsers(List<UserAction> userActions, int top) {
        Map<String, Long> usersToActionsCount = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return filterTopByAppearance(usersToActionsCount, top);
    }

    public List<String> topPopularHashtags(List<UserAction> userActions, int top) {
        String regex = "[^#\\w]";
        Map<String, Long> hashtags = userActions.stream()
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+"))
                        .filter(word -> word.startsWith("#")))
                .map(hashtag -> hashtag.replaceAll(regex, ""))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        return filterTopByAppearance(hashtags, top);
    }

    public List<String> topCommentersLastMonth(List<UserAction> userActions, int top) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        Map<String, Long> userNameToCommentsCount = userActions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT)
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return filterTopByAppearance(userNameToCommentsCount, top);
    }

    public Map<ActionType, Double> actionTypePercentages(List<UserAction> userActions) {
        double amountOfActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                Map.Entry::getKey,
                    entry -> entry.getValue() / amountOfActions * PERCENTAGE
        ));
    }
}
