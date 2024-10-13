package school.faang.m1s2.bjs2_35470_webAnalytics;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    private static final String PUNCT_REGEX = "[\\p{Punct}&&[^#]]";
    private static final String SPACE_REGEX = "\\s+";


    public static List<String> topActiveUsers(List<UserAction> list) {
        return list.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> list) {
        return list.stream()
                .filter(action -> action.getContent().contains("#"))
                .map(action -> action.getContent().replaceAll(PUNCT_REGEX, "").split(SPACE_REGEX))
                .flatMap(array -> Arrays.stream(array)
                        .filter(s -> s.startsWith("#"))
                )
                .collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey())
                .limit(5)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> list) {
        return list.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action -> (action.getActionDate().getMonthValue()) == (LocalDate.now().getMonthValue() - 1))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting())).entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey())
                .limit(3)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> list) {
        Map<String, Double> result = new HashMap<>();

        list.stream().
                collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting())).entrySet()
                .forEach(entry -> result.put(entry.getKey(), entry.getValue() / (double) list.size()));

        result.replaceAll((key, value) -> (double) Math.round((value) * 100));

        return result;
    }
}
