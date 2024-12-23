package school.faang.bjs247217;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        List<Integer> topIds = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry<Integer, Long>::getValue).reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();

        return actions.stream()
                .filter(action -> topIds.contains(action.getId()))
                .map(UserAction::getName)
                .distinct()
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream((content.split("\\s+"))))
                .filter(word -> word.startsWith("#"))
                .map(word -> word.replaceAll(Constants.ONLY_LETTERS_AND_SYMBOLS, ""))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate startOfCurrentMonth = LocalDate.now().withDayOfMonth(1);

        return actions.stream()
                .filter(userAction -> userAction.getActionDate().isAfter(startOfCurrentMonth)
                        || userAction.getActionDate().isEqual(startOfCurrentMonth))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        var totalActions = (long) actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .map(entry -> Map.entry(entry.getKey(), (entry.getValue() * 100.0) / totalActions))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
