package school.faang.socials;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static school.faang.socials.ActionType.COMMENT;

/**
 * @author Danil Pudovkin
 * @since 13.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions, int limit) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int limit) {
        return actions.stream()
                .flatMap(s -> Arrays.stream(s.content()
                        .replaceAll("[?!.]", "")
                        .split(" ")))
                .filter(s -> s.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int limit) {
        return actions.stream()
                .filter(a -> COMMENT.equals(a.actionType()))
                .filter(a -> a.actionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .limit(limit)
                .toList();

    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        action -> action.actionType().name(),
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> {
                                    var value = count * 100.0 / actions.size();
                                    double factor = Math.pow(10, 2);
                                    return Math.round(value * factor) / factor;
                                }
                        )
                ));
    }
}
