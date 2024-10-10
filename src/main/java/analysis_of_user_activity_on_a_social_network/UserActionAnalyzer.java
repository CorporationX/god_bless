package analysis_of_user_activity_on_a_social_network;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    /**
     * Finds the top 10 active users.
     *
     * @param userActions The {@link UserAction}s to analyze.
     * @return The top 10 active users in no particular order.
     */
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions
                .stream()
                .flatMap(action -> Stream.of(action.getName()))
                .distinct()
                .limit(10)
                .toList();
    }

    /**
     * Finds the top 5 popular hashtags.
     *
     * @param userActions The {@link UserAction}s to analyze.
     * @return The top 5 popular hashtags in descending order of frequency, with
     * no duplicates.
     */
    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        Map<String, Long> hashtagFrequency = userActions.stream()
                .map(UserAction::getContent)
                .filter(content -> content != null && !content.isEmpty())
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return hashtagFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .map(tag -> tag.replaceAll("\\.$", ""))
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * Finds the top 3 commenters over the last month.
     *
     * @param userActions The {@link UserAction}s to analyze.
     * @return The top 3 commenters, in descending order of comments made, with
     * no duplicates.
     */
    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);

        Map<String, Long> commenterCount = userActions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT))
                .filter(action -> action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return commenterCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    /**
     * Finds the percentage of actions for each action type.
     *
     * @param userActions The {@link UserAction}s to analyze.
     * @return A map where the keys are the names of the action types, and the
     * values are the percentage of actions for each type.
     */
    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        Map<ActionType, Long> actionCount = userActions
                .stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        long totalActions = userActions.size();

        return actionCount.entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().name(),
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }
}
