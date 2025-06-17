package school.faang.bjs2_81010;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final Pattern PATTERN_HASHTAG = Pattern.compile("#([a-zA-Z0-9]+)[\\W\\s]*?");
    private static final int HUNDRED_PERCENT = 100;

    public static List<UserAction> topActiveUsers(List<UserAction> actions, int maxSize) {
        Map<UserAction, Long> collect = actions.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return toTopList(collect, maxSize);
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int maxSize) {
        int groupNum = 1;

        Map<String, Long> countHashtags = actions.stream()
                .filter(action -> action.getContent() != null
                                  && (action.getActionType().equals(ActionType.COMMENT)
                                      || action.getActionType().equals(ActionType.POST)))
                .flatMap(hashtag -> PATTERN_HASHTAG.matcher(hashtag.getContent())
                        .results()
                        .map(matcher -> matcher.group(groupNum)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return toTopList(countHashtags, maxSize);
    }

    public static List<UserAction> topCommentersLastMonth(List<UserAction> actions, int maxSize) {
        Map<UserAction, Long> countCommentsUser = actions.stream()
                .filter(action -> action.getActionType().equals(ActionType.COMMENT)
                                  && (action.getActionDate().isAfter(LocalDate.now().minusMonths(1))))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return toTopList(countCommentsUser, maxSize);
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .map(UserAction::getActionType)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(
                        Collectors.counting(), count -> (double) count / actions.size() * HUNDRED_PERCENT)));
    }

    private static <T> List<T> toTopList(Map<T, Long> statistics, int maxSize) {
        return statistics.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(maxSize)
                .map(Map.Entry::getKey)
                .toList();
    }
}
