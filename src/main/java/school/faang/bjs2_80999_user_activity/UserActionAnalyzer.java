package school.faang.bjs2_80999_user_activity;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(@NonNull List<UserAction> actions, int n) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(a -> -a.getValue().size()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions, int n) {
        Map<String, Integer> hashtagsWithCount = new HashMap<>();

        actions.forEach(action ->
            Arrays.stream(action.getContent().split(" "))
                    .filter(w -> w.startsWith("#"))
                    .forEach(tag -> {
                        String strippedTag = tag.replaceAll("[!.?]", "");
                        int temp = hashtagsWithCount.computeIfAbsent(strippedTag, t -> 0);
                        hashtagsWithCount.put(strippedTag, temp + 1);
                    })
        );

        return hashtagsWithCount.entrySet().stream()
                .sorted(Comparator.comparingInt(a -> -a.getValue()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions, int n) {
        List<UserAction> filteredActions = actions.stream()
                .filter(action ->
                        action.getActionType() == ActionType.COMMENT
                                && action.getActionDate().getYear() == LocalDate.now().getYear()
                                && action.getActionDate().getMonth() == LocalDate.now().getMonth().minus(1)
                )
                .toList();
        return topActiveUsers(filteredActions, n);
    }

    public static Map<ActionType, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType))
                .entrySet()
                .stream().collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (double) Math.round((double) entry.getValue().size() / actions.size() * 1000) / 10
                ));
    }

}
