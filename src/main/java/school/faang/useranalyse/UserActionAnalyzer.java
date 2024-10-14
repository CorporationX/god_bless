package school.faang.useranalyse;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> findTopActiveUsers(List<UserAction> actions){

        // find top user ids
        List<Integer> topIds = actions.stream()

                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        // find top ids in the input list
        return topIds.stream()
                .map(id -> actions.stream()
                        .filter(action -> action.getId().equals(id))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .map(UserAction::getName).toList();

    }

    public static List<String> findTopPopularActions(List<UserAction> actions){

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();

    }

    public static List<String> findUsersWithMostCommentLastMonth(List<UserAction> actions){

        // filter by action type and date, and then find 3 common ids
        List<Integer> topIds = actions.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();

        // find top ids in the input list
        return topIds.stream()
                .map(id -> actions.stream()
                        .filter(action -> action.getId().equals(id))
                        .findFirst()
                        .orElse(null))
                .filter(Objects::nonNull)
                .map(UserAction::getName).toList();
    }

    public static List<Double> calculateActionPercentage(List<UserAction> actions){
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .values().stream()
                .map(aLong -> (double) Math.round(aLong * 100.0 / actions.size()))
                .toList();
    }
}
