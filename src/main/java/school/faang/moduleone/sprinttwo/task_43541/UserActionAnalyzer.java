package school.faang.moduleone.sprinttwo.task_43541;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> source) {
        Map<String, List<UserAction>> map = source.stream()
                .collect(Collectors.groupingBy(UserAction::getName));

        return map.entrySet().stream()
                .sorted((s1, s2) -> s2.getValue().size() - s1.getValue().size())
                .map(Map.Entry::getKey)
                .limit(10)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> source) {
        Map<String, Long> result = source.stream()
                .map(UserAction::getContent)
                .map(s -> Arrays.asList(s.split("[\\s.,!?;:-]+")))
                .flatMap(Collection::stream)
                .filter(s -> s.startsWith("#"))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        return result.entrySet().stream()
                .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> source) {
        return source.stream()
                .filter(it -> "comment".equals(it.getActionType()))
                .filter(it -> it.getActionDate().getMonthValue() == LocalDate.now().getMonthValue())
                .map(UserAction::getName)
                .collect(Collectors.groupingBy(name -> name, Collectors.counting()))
                .entrySet().stream()
                .sorted((e1, e2) -> Math.toIntExact(e2.getValue() - e1.getValue()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> source) {
        Map<String, List<UserAction>> userActionsByType = source.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType));

        int totalActions = source.size();

        Map<String, Double> percentagesByType = new HashMap<>();
        userActionsByType.forEach((type, action) -> {
            int count = action.size();
            BigDecimal bd = new BigDecimal((double) count / totalActions * 100);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            double percentage = bd.doubleValue();
            percentagesByType.put(type, percentage);
        });

        return percentagesByType;
    }
}
