package school.faang.traffic_analysis;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(@NonNull List<UserAction> actionList, int userAmount) {
        return actionList.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(userAmount)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actionList, int amountTopHashes) {
        return actionList.stream()
                .filter(action -> (ActionType.COMMENT.equals(action.actionType())
                        || ActionType.POST.equals(action.actionType()))
                        && !action.content().isBlank())
                .flatMap(action -> Arrays.stream(action.content().split("\\s+"))
                        .filter(word -> word.startsWith("#"))
                        .map(word -> word.replaceAll("[^a-zA-Z0-9#]", ""))
                        .filter(word -> !word.isEmpty()))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(amountTopHashes)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actionList, int userAmount) {
        return actionList.stream().filter(action ->
                        ActionType.COMMENT.equals(action.actionType())
                                && (action.actionDate().isAfter(LocalDate.now().minusMonths(1))
                                && action.actionDate().isBefore(LocalDate.now())))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(userAmount)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(@NonNull List<UserAction> actionList) {
        Map<String, Long> typesMap = actionList.stream()
                .collect(Collectors.groupingBy(action -> action.actionType().toString(), Collectors.counting()));
        double total = typesMap.values().stream().mapToDouble(Long::doubleValue).sum();

        return typesMap.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> {
                    if (total != 0) {
                        return (entry.getValue() * 100.0) / total;
                    } else {
                        return 0.0;
                    }
                }
        ));
    }
}
