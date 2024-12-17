package school.faang.task_47207;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class UserActionAnalyzer {
    public List<String> topActiveUsers(List<UserAction> actions, int quantity) {
        return requireNonNullList(actions).stream()
                .collect(Collectors.groupingBy(
                        UserAction::user, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(quantity)
                .map(userEntry -> userEntry.getKey().toString())
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions, int quantity) {
        return requireNonNullList(actions).stream()
                .filter(userAction ->
                        userAction.actionType() == ActionType.COMMENT
                                || userAction.actionType() == ActionType.POST)
                .flatMap(userAction ->
                        Arrays.stream(userAction.content().split("\\s"))
                                .filter(word -> word.startsWith("#"))
                                .map(word -> word.replaceAll("\\W", "")))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(quantity)
                .toList();
    }

    public List<String> topCommentersLastMonth(List<UserAction> actions, int quantity) {
        return requireNonNullList(actions).stream()
                .filter(userAction ->
                        userAction.actionType() == ActionType.COMMENT
                                && userAction.actionDate().isAfter(
                                LocalDate.now().withDayOfMonth(1))
                        )
                .collect(Collectors.groupingBy(
                        UserAction::user, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .limit(quantity)
                .map(entry -> entry.getKey().toString())
                .toList();
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        return requireNonNullList(actions).stream()
                .collect(Collectors.groupingBy(
                        UserAction::actionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        entry -> entry.getValue().doubleValue() / actions.size()
                ));
    }

    private <T> List<T> requireNonNullList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        try {
            list.forEach(Objects::requireNonNull);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("List cannot contain null");
        }
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return list;
    }
}
