package school.faang.godbless.bjs2_35446;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static school.faang.godbless.bjs2_35446.UserAction.ActionType.*;

public class UsersActivityManager {
    private static final Set<Character> PUNCTUATION = Set.of('.', ',', '!', '?');

    public static List<String> topActiveUsers(@NonNull List<UserAction> actions) {
        return actions.stream().collect(Collectors.groupingBy(UserAction::getId)).entrySet()
                .stream().sorted((a, b) -> b.getValue().size() - a.getValue().size()).limit(10)
                .map(entry -> entry.getValue().get(0).getName()).toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions) {
        return actions.stream().filter(action -> action.getActionType().equals(POST) || action.getActionType().equals(COMMENT))
                .map(UserAction::getContent).map(content -> content.split(" "))
                .flatMap(Arrays::stream).filter(word -> word.startsWith("#")).map(UsersActivityManager::clearWord)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream().sorted((a, b) -> (int) (b.getValue() - a.getValue())).limit(5)
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
        if (PUNCTUATION.contains(lastSymbol)) {
            return word.substring(0, word.length() - 1);
        }
        return word;
    }
}
