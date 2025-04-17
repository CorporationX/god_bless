package school.faang.analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<Integer, Long> userActivityCounts = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getUserId,
                        Collectors.counting()
                ));

        List<Integer> topUserIds = userActivityCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();

        return topUserIds.stream()
                .map(buildMapIdToName(actions)::get)
                .toList();
    }

    private static Map<Integer, String> buildMapIdToName(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.toMap(
                        UserAction::getUserId,
                        UserAction::getUserName,
                        (existing, replacement) -> existing
                ));
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        List<String> allHashtags = actions.stream()
                .filter(action -> action.getActionType() == ActionType.POST
                        || action.getActionType() == ActionType.COMMENT)
                .flatMap(action -> extractHashtags(action.getContent()).stream())
                .toList();

        Map<String, Long> hashtagPopularity = allHashtags.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        return hashtagPopularity.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static List<String> extractHashtags(String content) {
        return Arrays.stream(content.split("\\s+"))
                .filter(word -> word.startsWith("#"))
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        List<UserAction> monthComments = actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .toList();

        Map<Integer, Long> commentCounts = monthComments.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getUserId,
                        Collectors.counting()
                ));

        return commentCounts.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(n)
                .map(entry -> buildMapIdToName(actions).get(entry.getKey()))
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        entry -> (double) entry.getValue() / totalActions * 100
                ));
    }
}
