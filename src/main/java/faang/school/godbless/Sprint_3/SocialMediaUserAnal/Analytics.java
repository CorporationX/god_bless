package faang.school.godbless.Sprint_3.SocialMediaUserAnal;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Analytics {

    public static List<Integer> mostActive(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> mostPopularTopics(List<UserAction> userActions) {
        return userActions.stream()
                .map(UserAction::getContent)
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey).toList();
    }

    public static List<Integer> lastComments(List<UserAction> userActions) {
        LocalDateTime ago = LocalDateTime.now().minusMonths(1);
        return userActions.stream()
                .filter(ua -> ua.getActionType().equals("comment"))
                .filter(ua -> ua.getActionDate().isAfter(ago))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey).toList();
    }

    public static Map<String, Double> getPersent(List<UserAction> userActions) {
        long amountOfActions = userActions.size();
        Map<String, Double> groupByType = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, (Collectors.summingDouble(action -> 1.0))));
        groupByType.replaceAll((key, value) -> (value / amountOfActions) * 100);
        return groupByType;
    }

}
