package school.faang.analysing_user_activity_in_a_social_network.BJS2_58080;

import lombok.NonNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(@NonNull List<UserAction> actions, int topSize) {
        return actions.stream()
                .collect(Collectors.toMap(
                        UserAction::getId,
                        userAction -> new Pair<>(1L, userAction.getName()),
                        (existing, replacement) -> {
                            existing.setFirst(existing.getFirst() + replacement.getFirst());
                            return existing;
                        })).entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparingLong((Pair<Long, String> pair) -> pair.getFirst()).reversed())
                .map((Pair::getSecond))
                .limit(topSize)
                .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions, int topSize) {
        return actions.stream()
                .map(UserAction::getContent)
                .flatMap(string -> Arrays.stream(string.split(" ")))
                .map(word -> word.replaceAll("[\\p{Punct}]+$", ""))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(
                        word -> word,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Comparator.comparingLong((Map.Entry<String, Long> entry) -> entry.getValue()).reversed())
                .map(Map.Entry::getKey)
                .limit(topSize)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions, int topSize) {
        return actions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.toMap(
                        UserAction::getId,
                        userAction -> new Pair<>(1L, userAction.getName()),
                        (existing, replacement) -> {
                            existing.setFirst(existing.getFirst() + replacement.getFirst());
                            return existing;
                        })).entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparingLong((Pair<Long, String> pair) -> pair.getFirst()).reversed())
                .map((Pair::getSecond))
                .limit(topSize)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() / (double) actions.size()) * 100
                ));
    }

}
