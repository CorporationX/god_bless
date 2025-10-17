package school.faang.m1.stream.user.analysis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    // -------- 1) Топ-N активных пользователей --------
    public static List<String> topActiveUsers(List<UserAction> actions, int i) {
        if (actions == null || actions.isEmpty() || i <= 0) {
            return Collections.emptyList();
        }
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(i)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // -------- 2) Топ-N популярных хэштегов (#tag) в POST/COMMENT --------
    private static final Pattern HASHTAG = Pattern.compile("(^|\\s)#([\\p{L}\\p{N}_]+)");

    private static List<String> extractHashtags(String text) {
        List<String> tags = new ArrayList<>();
        Matcher m = HASHTAG.matcher(text);
        while (m.find()) {
            // m.group(2) — сам тег без '#'
            tags.add("#" + m.group(2));
        }
        return tags;
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int i) {
        if (actions == null || actions.isEmpty() || i <= 0) {
            return Collections.emptyList();
        }
        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.POST || a.getActionType() == ActionType.COMMENT)
                .map(UserAction::getContent)
                .filter(c -> c != null && !c.isEmpty())
                .flatMap(c -> extractHashtags(c).stream())
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(i)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // -------- 3) Топ-N комментаторов за последний месяц --------
    public static List<String> topCommentersLastMonth(List<UserAction> actions, int i) {
        if (actions == null || actions.isEmpty() || i <= 0) {
            return Collections.emptyList();
        }
        LocalDate end = actions.stream()
                .map(UserAction::getActionDate)
                .max(Comparator.naturalOrder())
                .orElse(LocalDate.now());
        LocalDate startExclusive = end.minusMonths(1);
        return actions.stream()
                .filter(a -> a.getActionType() == ActionType.COMMENT)
                .filter(a -> a.getActionDate().isAfter(startExclusive) && !a.getActionDate().isAfter(end))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(i)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // -------- 4) Проценты по типам действий --------
    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> actions) {
        EnumMap<ActionType, Double> result = new EnumMap<>(ActionType.class);
        if (actions == null || actions.isEmpty()) {
            for (ActionType t : ActionType.values()) {
                result.put(t, 0.0);
                return result;
            }
        }

        long total = actions.size();
        Map<ActionType, Long> counts = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType,
                        () -> new EnumMap<>(ActionType.class),
                        Collectors.counting()));

        for (ActionType t : ActionType.values()) {
            long c = counts.getOrDefault(t, 0L);
            result.put(t, (c * 100.0) / total);
        }
        return result;
    }
}