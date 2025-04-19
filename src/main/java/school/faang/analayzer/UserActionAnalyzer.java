package school.faang.analayzer;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    private static final Pattern HASHTAG_PATTERN = Pattern.compile("#(\\w+)");

    private static String getHashtag(UserAction action) {
        Matcher matcher = HASHTAG_PATTERN.matcher(action.content());
        return matcher.find() ? matcher.group() : "";
    }

    private static final Comparator<Map.Entry<String, Long>> MAP_BY_VALUE_REVERSED_COMPARATOR =
            Map.Entry
                    .comparingByValue(Comparator.comparingInt(Long::intValue).reversed());

    public static List<String> topActiveUsers(List<UserAction> actions, int limit) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(MAP_BY_VALUE_REVERSED_COMPARATOR)
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(userAction -> userAction.content().contains("#"))
                .collect(Collectors.groupingBy(UserActionAnalyzer::getHashtag, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(MAP_BY_VALUE_REVERSED_COMPARATOR)
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(userAction -> userAction.actionType().equals(ActionType.COMMENT)
                        && userAction.localDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(MAP_BY_VALUE_REVERSED_COMPARATOR)
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();
    }

    public static Map<String, String> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(userAction ->
                        userAction.actionType().name(), Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry ->
                        "%.1f %%".formatted(Double.valueOf(entry.getValue()) / actions.size() * 100)));
    }
}