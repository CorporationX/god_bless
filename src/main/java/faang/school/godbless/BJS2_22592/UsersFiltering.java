package faang.school.godbless.BJS2_22592;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UsersFiltering {

    public static List<String> mostActiveUsers(List<UserAction> userActions){
        return userActions.stream().collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(10)
                .flatMap(entry -> userActions.stream()
                        .filter(userAction -> userAction.getId() == entry.getKey())
                        .map(userAction -> userAction.getName() + userAction.getId() + " - " + entry.getValue()))
                .toList();
    }

    public static List<String> mostPopularThemes(List<UserAction> userActions){
        return userActions.stream().flatMap(userAction -> Arrays.stream(userAction.getContent().split(" ")))
                .filter(word -> word.startsWith("#")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<UserAction> mostCommentUsers(List<UserAction> userActions){
        return userActions.stream().filter(userAction -> userAction.getContent().contains("comment")
                        && userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(3)
                .map(entry -> userActions.stream()
                        .filter(action -> action.getId() == entry.getKey())
                        .findFirst()
                        .orElse(null))
                .collect(Collectors.toList());
    }

    public static Map<Action, Double> findActionPercentage(List<UserAction> userActions){
            return userActions.stream()
                    .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                    .entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getKey, entry -> (entry.getValue() * 100.0) / userActions.size()));
    }
}
