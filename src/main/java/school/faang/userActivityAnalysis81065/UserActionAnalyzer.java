package school.faang.userActivityAnalysis81065;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> list, int numActions) {

        return list.stream().collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(numActions)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> list, int numActions) {

        return list.stream().filter(i -> i.getContent().contains("#")
                        && i.getActionType() == ActionType.COMMENT || i.getActionType() == ActionType.POST)
                .map(i -> i.getContent()
                        .replaceAll(".*?(#\\w+).*?", "$1 ").replaceAll("[^#\\w]", ""))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(numActions)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> list, int numActions) {

        return list.stream().filter(i -> i.getActionType() == ActionType.COMMENT)
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(numActions)
                .map(Map.Entry::getKey).toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> list) {
        return list.stream().collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(e -> e.getKey().name(), e -> {
                    double percentage = (double) e.getValue() / list.size() * 100;
                    return Math.round(percentage * 100.0) / 100.0;
                }));
    }
}

