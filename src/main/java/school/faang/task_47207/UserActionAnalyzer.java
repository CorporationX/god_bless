package school.faang.task_47207;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<String> topActiveUsers(List<UserAction> actions, int quantity) {
        return requireNonNullList(actions).stream()
                .collect(Collectors.groupingBy(
                        UserAction::user, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .map(userEntry -> String.format("%s %d",
                        userEntry.getKey(), userEntry.getValue()))
                .limit(quantity)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions, int quantity) {
        return requireNonNullList(actions).stream()
                .filter(userAction ->
                        userAction.actionType().equals(ActionType.COMMENT)
                                || userAction.actionType().equals(ActionType.POST))
                .map(UserAction::content)
                .flatMap(content -> Arrays.stream(content.split("\\s+"))
                        .filter(word -> word.startsWith("#"))
                        .map(word -> word.replaceAll("\\W", "")))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(hashtagEntry -> String.format("%s %d",
                        hashtagEntry.getKey(), hashtagEntry.getValue()))
                .limit(quantity)
                .toList();
    }

    public List<String> topCommentersLastMonth(List<UserAction> actions, int quantity) {
        List<UserAction> comments = requireNonNullList(actions).stream()
                .filter(userAction ->
                        userAction.actionType().equals(ActionType.COMMENT))
                .toList();
        LocalDate firstDateOfLastMonth = comments.stream()
                .map(UserAction::actionDate)
                .max(LocalDate::compareTo)
                .orElseThrow(() ->
                        new IllegalArgumentException("Comments not found"))
                .withDayOfMonth(1);

        return comments.stream()
                .filter(comment -> comment.actionDate()
                        .isAfter(firstDateOfLastMonth))
                .collect(Collectors.groupingBy(
                        UserAction::user, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<User, Long>comparingByValue().reversed())
                .map(userEntry -> String.format("%s %d",
                        userEntry.getKey(), userEntry.getValue()))
                .limit(quantity)
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

        List<T> checkedList = list.stream()
                .filter(Objects::nonNull)
                .toList();

        if (checkedList.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return checkedList;
    }
}
