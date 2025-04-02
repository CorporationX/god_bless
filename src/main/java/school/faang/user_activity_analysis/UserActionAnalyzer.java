package school.faang.user_activity_analysis;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions, int topN) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int topN) {
        return actions.stream()
                .flatMap(action -> action.getContent() == null || action.getContent().isBlank()
                        ? Stream.empty() :
                        Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy((wordWithHashtag -> wordWithHashtag), Collectors.counting()))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .map(Map.Entry::getKey)
                .limit(topN)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int topN) {
        return actions.stream()
                .filter(action -> Objects.equals(action.getActionType(), ActionType.COMMENT))
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .limit(topN)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        if (actions.isEmpty()) {
            return Map.of();
        }
        return actions.stream()
                .collect(Collectors.groupingBy(
                        action -> action.getActionType().name(),
                        Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) entry.getValue() / actions.size()));
    }

}
