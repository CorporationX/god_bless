package school.faang.bjs2_88167;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#\\w+");
    private static final Pattern HASHTAG_CLEANUP_PATTERN = Pattern.compile("[^a-zA-Z0-9_#]");

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> counts = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        Set<Map.Entry<String, Long>> entries = counts.entrySet();

        Stream<Map.Entry<String, Long>> sortedStream = entries.stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()));

        List<String> topUsers = sortedStream
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return topUsers;
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        Stream<String> hashtagStream = actions.stream()
                .filter(a -> a.getActionType() == ActionType.POST || a.getActionType() == ActionType.COMMENT)
                .map(UserAction::getContent)
                .flatMap(content -> HASHTAG_PATTERN
                        .matcher(content)
                        .results()
                        .map(MatchResult::group)
                        .map(hashtag -> HASHTAG_CLEANUP_PATTERN.matcher(hashtag).replaceAll("")));

        Map<String, Long> counts = hashtagStream.collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting()));

        return counts.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate now = LocalDate.now();
        LocalDate oneMonthAgo = now.minusMonths(1);

        return actions.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> {
                    LocalDate date = action.getActionDate();
                    return !date.isBefore(oneMonthAgo) && !date.isAfter(now);
                })
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        long total = actions.size();

        Map<ActionType, Long> counts = actions.stream()
                        .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        Map<ActionType, Double> result = new EnumMap<>(ActionType.class);

        counts.forEach((key, value) -> {
            double percentage = value * 100.0 / total;
            result.put(key, percentage);
        });

        for (ActionType type : ActionType.values()) {
            result.putIfAbsent(type, 0.0);
        }

        return result;
    }
}