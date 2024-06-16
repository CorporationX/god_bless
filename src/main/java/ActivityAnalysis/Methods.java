package ActivityAnalysis;


import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Methods {

    public static List<Integer> findTopTenActiveUsers(List<UserAction> user) {
        return user.stream().
                collect(Collectors.groupingBy(UserAction::getId, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                limit(10).map(Map.Entry::getKey).toList();
    }

    public static List<String> findTonFiveTopic(List<UserAction> user) {
        return user.stream().
                filter(acton -> acton.getActonType().equals("post") || acton.getActonType().equals("comment")).
                map(UserAction::getContent).
                filter(content -> content.startsWith("#")).
                collect(Collectors.groupingBy(x -> x, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                limit(5).map(Map.Entry::getKey).toList();
    }

    public static List<String> findTopThreeUsersByContent(List<UserAction> user) {
        Date lastMonth = Date.from(ZonedDateTime.now().minusMonths(1).toInstant());
        // Если нужно вернуть Id то поменять userId на return
        List<Integer> userID = user.stream().
                filter(date -> date.getActionDate().after(lastMonth)).
                filter(actionType -> actionType.getActonType().equals("comment")).
                collect(Collectors.groupingBy(UserAction::getId, Collectors.counting())).
                entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                limit(3).map(Map.Entry::getKey).toList();
        // Если нужно вернуть имя то оставить так
        return userID.stream().map(id -> user.get(id).getName()).toList();
    }

    public static Map<String, Long> findPercentageForAction(List<UserAction> user) {
        Map<String, Long> action = user.stream().
                collect(Collectors.groupingBy(UserAction::getActonType, Collectors.counting()));
        long totalPercentage = action.values().stream().mapToLong(l -> l).sum();
        return action.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, value -> (value.getValue() * 100 / totalPercentage)));
    }
}