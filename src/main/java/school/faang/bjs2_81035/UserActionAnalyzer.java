package school.faang.bjs2_81035;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {


    public static List<String> topActiveUsers(List<UserAction> users, int limit) {
        if (isInvalidUsers(users)) {
            return Collections.emptyList();
        }

        return users.stream()
                .collect(Collectors.groupingBy(
                        UserAction::name,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> users, int limit) {
        if (isInvalidUsers(users)) {
            return Collections.emptyList();
        }

        return users.stream()
                .flatMap(user -> Stream.of(user.content().split("\\s+")))
                .filter(str -> str.matches("#\\w+"))
                .collect(Collectors.groupingBy(
                        str -> str,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> users, int limit) {
        if (isInvalidUsers(users)) {
            return Collections.emptyList();
        }

        LocalDate monthAgo = LocalDate.now().minusDays(30);
        return users.stream()
                .filter(user -> user.actionType().equals(ActionType.COMMENT))
                .filter(user -> user.actionDate().isBefore(monthAgo))
                .collect(Collectors.groupingBy(
                        UserAction::name,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(limit)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> users) {
        if (isInvalidUsers(users)) {
            return Map.of();
        }

        double totalUsers = users.size();
        return users.stream()
                .collect(Collectors.groupingBy(
                        UserAction::actionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().toString(),
                        entry -> Math.round(entry.getValue() / totalUsers * 10_000) / 100.0
                ));
    }

    private static boolean isInvalidUsers(List<UserAction> users) {
        return users == null || users.isEmpty();
    }

}
