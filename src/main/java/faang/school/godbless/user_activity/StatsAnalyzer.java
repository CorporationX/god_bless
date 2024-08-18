package faang.school.godbless.user_activity;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatsAnalyzer {

    public static List<String> top10UsersByAction(List<UserAction> userStats, ActionType action) {

        return topResultsByCondition(
                userStats.stream(),
                us -> us.getActionType().equals(action),
                UserAction::getUsername,
                10
        );
    }

    public static List<String> top5HashtagsInPostsComments(List<UserAction> userStats) {
        return topResultsByCondition(
                userStats.stream()
                .filter(us -> List.of(ActionType.POST, ActionType.COMMENT).contains(us.getActionType()))
                .flatMap(us -> {
                    String content = us.getContent();
                    return Stream.of(content.substring(content.indexOf("#") + 1).split("#"));
                })
                .peek(System.out::println),
                tag -> !tag.isEmpty(),
                Function.identity(),
                5
        );
    }

    public static List<String> top3UsersByCommentsLastMonth(List<UserAction> userStats) {
        return topResultsByCondition(
                userStats.stream(),
                ((Predicate<UserAction>)us -> us.getActionType().equals(ActionType.COMMENT))
                        .and(us -> us.getActionDate().isAfter(LocalDate.now().minusMonths(1))),
                UserAction::getUsername,
                3
        );
    }

    public static double actionPercentage(List<UserAction> userStats, ActionType action, int dp) {
        if (dp <= 0 || dp >= 5) {
            throw new IllegalArgumentException("Decimal places should belong in range [1, 4]");
        }

        DecimalFormat df = new DecimalFormat("0." + "0".repeat(dp));
        String percentageString = df.format(userStats.stream()
                .filter(us -> us.getActionType().equals(action))
                .count() / (double)userStats.size() * 100);
        return Double.parseDouble(percentageString);
    }

    public static <T> List<String> topResultsByCondition(Stream<T> stream,
                                               Predicate<T> filter,
                                               Function<T, String> keyFunction,
                                               int limit) {
        return stream
                .filter(filter)
                .collect(Collectors.groupingBy(keyFunction, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Math.toIntExact(e2.getValue() - e1.getValue()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }
}
