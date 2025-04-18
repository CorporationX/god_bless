package school.faang.streamApi.user_activity;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActivityAnalyzer {

    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#(\\w+)");
    private static final Comparator<Map.Entry<String, Long>> REVERSED_MAP_VALUE_COMPARATOR =
            Map.Entry.<String, Long>comparingByValue().reversed();

    private static String matchPattern(UserAction userAction) {
        Matcher matcher = HASHTAG_PATTERN.matcher(userAction.content());
        return matcher.find() ? matcher.group() : "";
    }

    public static List<String> getMostActiveUsers(List<UserAction> userActions, int limit) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(REVERSED_MAP_VALUE_COMPARATOR)
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getMostPopularTags(List<UserAction> userActions, int limit) {
        return userActions.stream()
                .filter(userAction -> !Objects.isNull(userAction.content()) && userAction.content().startsWith("#"))
                .collect(Collectors.groupingBy(UserActivityAnalyzer::matchPattern, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(REVERSED_MAP_VALUE_COMPARATOR)
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> userActions, int limit) {
        LocalDate lastMonth = LocalDate.now().minusMonths(1);

        return userActions.stream()
                .filter(userAction -> Objects.equals(ActionType.COMMENT, userAction.actionType())
                        && userAction.actionDate().isAfter(lastMonth))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(REVERSED_MAP_VALUE_COMPARATOR)
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, String> getActionPercentage(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> "%.1f%%".formatted(entry.getValue() * 100.0 / userActions.size())
                ));
    }

}
