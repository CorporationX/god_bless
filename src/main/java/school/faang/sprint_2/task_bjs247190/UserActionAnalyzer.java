package school.faang.sprint_2.task_bjs247190;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@UtilityClass
public class UserActionAnalyzer {

    public List<String> topActiveUsers(List<UserAction> actions, int numberOfUsers) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(numberOfUsers)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions, int numberOfHashTags) {
        return actions.stream()
                .map(UserAction::content)
                .filter(content -> content.contains("#"))
                .flatMap(content -> Arrays.stream(content.split(" ")))
                .filter(word -> word.matches("#\\w+"))
                .collect(Collectors.groupingBy(hashtag -> hashtag, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(numberOfHashTags)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topCommentersLastMonth(
            List<UserAction> actions, String actionType, int numberTopCommenters) {
        return actions.stream()
                .filter(action -> action.actionDate()
                        .isAfter(LocalDate.now().minusMonths(1)))
                .filter(action -> Objects.equals(action.actionType(), actionType))
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<String, Long>::getValue).reversed())
                .limit(numberTopCommenters)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry<String, Long>::getKey,
                        entry -> entry.getValue() * 100.0 / actions.size()
                ));
    }
}
