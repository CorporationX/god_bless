package school.faang.userAcrion;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {


    public static List<String> topActiveUsers (List<UserAction> userActions) {
       return userActions.stream()
               .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
               .entrySet().stream()
               .limit(10)
               .map(Map.Entry::getKey)
               .collect(Collectors.toList());
    }

    public static List<String> topPopularHashtags (List<UserAction> userActions) {
        return userActions.stream().filter(e -> e.getActionType().equals("post")).
                flatMap(action -> Arrays.stream(action.getContent().split("\\s+"))).
                filter(content -> content.startsWith("#")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
                        entrySet().
                        stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).
                        limit(5).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static List<String> topCommentersLastMonth (List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(action -> action.getActionType().equals("comment") && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> actionTypePercentages (List<UserAction> userActions){
        double posts = userActions.stream().filter(e -> e.getActionType().equals("post")).count();
        double comments = userActions.stream().filter(e -> e.getActionType().equals("comment")).count();
        double likes = userActions.stream().filter(e -> e.getActionType().equals("like")).count();
        double shares = userActions.stream().filter(e -> e.getActionType().equals("share")).count();

        double total = userActions.size();

        Map<String, Double> result = Map.of("posts", posts / total * 100, "comments", comments / total * 100, "likes", likes / total * 100, "shares", shares / total * 100);

        return result;

    }

}
