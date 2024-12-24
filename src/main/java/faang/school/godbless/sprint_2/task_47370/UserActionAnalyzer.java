package faang.school.godbless.sprint_2.task_47370;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        checkListForNull(userActions);
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        checkListForNull(userActions);
        String hashtag = "#";
        return userActions.stream()
                .filter(u -> u.getContent() != null && u.getContent().contains(hashtag))
                .flatMap(u -> {
                    String[] strings = u.getContent().split(" ");
                    return Arrays.stream(strings).filter(s -> s.startsWith(hashtag)).toList().stream();
                })
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        checkListForNull(userActions);
        return userActions.stream()
                .filter(u -> u.getActionType() == ActionType.COMMENT)
                .filter(u -> u.getActionDate() != null)
                .filter(u -> u.getActionDate().getMonth() == LocalDate.now().minusMonths(1).getMonth())
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> actionTypePercentages(List<UserAction> userActions) {
        checkListForNull(userActions);
        int numberOfUserActions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, c -> ((double) c.getValue() / numberOfUserActions) * 100));
    }

    private static void checkListForNull(List<?> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        if (list.contains(null)) {
            throw new IllegalArgumentException("List cannot contain null");
        }
    }
}
