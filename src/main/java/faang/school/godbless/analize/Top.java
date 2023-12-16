package faang.school.godbless.analize;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Top {
    public static List<String> topActive(List<UserAction> userActions) {
        Map<Integer, Long> actionCountUser = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));
        return actionCountUser.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(10)
                .map(entry -> " User id: " + entry.getKey() + "- actionCount: " + entry.getValue())
                .distinct()
                .toList();
    }

    public static List<String> topPopular(List<UserAction> userActions) {
        Map<String, Long> hashTagCount = userActions.stream()
                .filter(userAction1 -> userAction1.getActionType().equals("post")
                        && userAction1.getContent().contains("#")
                        || userAction1.getActionType().equals("comment")
                        && userAction1.getContent().contains("#"))
                .collect(Collectors.groupingBy(UserAction::getContent, Collectors.counting()));
        return hashTagCount.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(entry -> "hash: " + entry.getKey() + " -count: " + entry.getValue())
                .distinct()
                .toList();

    }

    public static List<String> topComments(List<UserAction> userActions) {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        Map<Integer, Long> actionCountUser = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("comment") && userAction.getActionDate().isAfter(thirtyDaysAgo.atStartOfDay()))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));
        return actionCountUser.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> " User id: " + entry.getKey() + " - actionCount: " + entry.getValue())
                .distinct()
                .toList();


    }

    public static List<String> percent(List<UserAction> userActions) {
        Map<String, Long> actionPercent = userActions.stream()
                .filter(userAction -> userAction.getActionType().equals("post")
                        || userAction.getActionType().equals("comment")
                        || userAction.getActionType().equals("like")
                        || userAction.getActionType().equals("share"))
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));

        long k = actionPercent.values().stream()
                .mapToLong(aLong -> aLong)
                .sum();

        return actionPercent.entrySet().stream()
                .map(entry -> {
                    String action = entry.getKey();
                    long count = entry.getValue();
                    double percent = (count / 100.0) * k;
                    return String.format("%s: %.2f%%", action, percent);
                })
                .toList();
    }
}
