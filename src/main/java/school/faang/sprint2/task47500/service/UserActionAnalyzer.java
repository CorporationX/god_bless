package school.faang.sprint2.task47500.service;

import school.faang.sprint2.task47500.model.UserAction;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }


    public static List<String> topPopularHashtags(List<UserAction> userActions) {
        return userActions.stream()
                .filter(a -> ((a.getActionType().equals("post")
                        || a.getActionType().equals("comment"))
                        && !a.getContent().isEmpty()))
                .flatMap(a -> Stream.of(a.getContent().split("[,.!\\s]+")))
                .filter(w -> w.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

    }

    public static List<String> topCommentersLastMonth(List<UserAction> userActions) {
        return userActions.stream()
                .filter(a -> (a.getActionType().equals("comment")
                        && a.getActionDate().isAfter(LocalDate.now().minusDays(365))))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(3)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> userActions) {
        double userActionsQty = userActions.size();
        System.out.println(userActionsQty);
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0 / userActionsQty))
                );
    }

}
