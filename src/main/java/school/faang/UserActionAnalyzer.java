package school.faang;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> getTopActiveUsers(List<UserAction> actions) {
        Map<String, Long> groupedByActionType = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        List<String> topActiveUsers = groupedByActionType.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(10)
                .collect(Collectors.toList());
        return topActiveUsers;
    }

    public static List<String> getTopPopularTopics(List<UserAction> actions) {
        Map<String, Long> groupedByPopularTopics = actions.stream()
                .flatMap(action -> Arrays.stream(action.getContent().split("[\\\s,.!?]+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        List<String> topPopularTopics = groupedByPopularTopics.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.toList());
        return topPopularTopics;
    }

    public static List<String> getTopUsersLeftCommentsByLastMonth(List<UserAction> actions) {
        Month lastMonth = LocalDate.now().minusMonths(1).getMonth();
        Map<String, Long> groupedByLastMonth = actions.stream()
                .filter(date -> date.getActionDate().getMonth().equals(lastMonth))
                .filter(actType -> actType.getActionType().equals("comment"))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        List<String> topUsersLeftComments = groupedByLastMonth.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
        return topUsersLeftComments;
    }

    public static Map<String, Double> calculatePercentByActionTypes(List<UserAction> actions) {
        long totalActionTypes = actions.size();
        Map<String, Double> calculatedPercentByActionType = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / totalActionTypes
                ));
        return calculatedPercentByActionType;
    }
}
