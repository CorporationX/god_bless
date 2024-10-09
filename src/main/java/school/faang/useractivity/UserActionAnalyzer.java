package school.faang.useractivity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> topActiveUsers(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(a -> a.getName(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long totalActions = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getPost, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        k -> k.getKey(),
                        entry -> (entry.getValue() * 100.0) / totalActions
                ));
    }

    public static List<String> topFiveTags(List<UserAction> actions) {
        return actions.stream()
                .filter(a -> a.getPost().equals("post") &&
                        !a.getContent().isEmpty() || a.getPost().equals("comment"))
                .flatMap(a -> Arrays.stream(a.getContent().split("\\\\\\\\s+")))
                .filter(w -> w.startsWith("#"))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {
        LocalDate oneMonth = LocalDate.now().minusMonths(1);

        return actions.stream()
                .filter(u -> u.getPost().equals("comment") && ((LocalDate) u.getDate()).isAfter(oneMonth))
                .collect(Collectors.groupingBy(u -> u.getName(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }
}
