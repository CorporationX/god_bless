package school.faang.godbless.bjs2_35446;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static school.faang.godbless.bjs2_35446.UserAction.ActionType.*;

public class UsersActivityManager {
    private static Set<Character> PUNTUATION = Set.of('.', ',', '!', '?');

    public static List<String> topActiveUsers(@NonNull List<UserAction> actions) {
        return actions.stream().collect(Collectors.groupingBy(UserAction::getId)).entrySet()
                .stream().sorted((a, b) -> b.getValue().size() - a.getValue().size()).limit(10)
                .map(entry -> entry.getValue().get(0).getName()).toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions) {
        Map<String, Integer> countHashtags = new HashMap<>();
        actions.stream()
                .filter(action -> action.getActionType().equals(POST) || action.getActionType().equals(COMMENT))
                .forEach(action -> {
                    String text = action.getContent();
                    StringTokenizer tokenizer = new StringTokenizer(text);
                    while (tokenizer.hasMoreTokens()) {
                        String word = clearWord(tokenizer.nextToken());
                        if (word.charAt(0) == '#') {
                            countHashtags.computeIfAbsent(word, key -> 0);
                            countHashtags.put(word, countHashtags.get(word) + 1);
                        }
                    }
                });
        return countHashtags.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).limit(5)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.getActionType().equals(COMMENT)
                        && action.getDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getId))
                .entrySet().stream().sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .limit(3).map(entry -> entry.getValue().get(0).getName()).toList();
    }

    public static Map<UserAction.ActionType, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        return actions.stream().collect(Collectors.groupingBy(UserAction::getActionType))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> 100 * (double) entry.getValue().size() / actions.size()));
    }

    private static String clearWord(@NonNull String word) {
        char lastSymbol = word.charAt(word.length() - 1);
        if (PUNTUATION.contains(lastSymbol)) {
            return word.substring(0, word.length() - 1);
        }
        return word;
    }
}
