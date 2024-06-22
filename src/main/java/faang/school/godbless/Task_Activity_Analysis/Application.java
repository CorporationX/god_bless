package faang.school.godbless.Task_Activity_Analysis;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Application {

    public static List<Integer> findTheMostActiveUsers(List<UserAction> userActions) {
        Map<Integer, Integer> namesAndActions = new HashMap<>();
        userActions.forEach(x -> {
            int numberOfActions = (int) userActions.stream().filter(y -> y.getId() == x.getId()).count();
            namesAndActions.put(x.getId(), numberOfActions);
        });
        return namesAndActions.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).limit(10)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> findPopularTopics(List<UserAction> userActions) {
        Map<String, Integer> hashtagStats = new HashMap<>();
        List<String> hashtags = userActions.stream().map(UserAction::getContent).
                filter(x -> x.startsWith("#")).toList();
        hashtags.forEach(x -> {
            int quantity = (int) hashtags.stream().filter(y -> y.equals(x)).count();
            hashtagStats.put(x, quantity);
        });
        return hashtagStats.entrySet().stream().
                sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                limit(5).map(Map.Entry::getKey).toList();
    }

    public static List<Integer> findTopCommentators(List<UserAction> userActions) {
        Map<Integer, Integer> idsAndComments = new HashMap<>();
        List<UserAction> comments = userActions.stream().filter(x -> x.getActionType().equals(UserAction.ActionType.comment))
                .filter(x -> x.getActionDate().isAfter(LocalDate.of(2024, 5, 31))).toList();
        comments.forEach(x -> {
            int commentQuantity = (int) comments.stream().filter(y -> y.getId() == (x.getId())).count();
            idsAndComments.put(x.getId(), commentQuantity);
        });
        return idsAndComments.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(3).map(Map.Entry::getKey).collect(Collectors.toList());
    }

    public static Map<String, Double> calculatePercentsOfActions(List<UserAction> userActions) {
        double numberOfActions = userActions.size();
        Map<String, Double> results = new HashMap<>();
        userActions.stream().map(UserAction::getActionType)
                .forEach(x -> {
                    results.computeIfPresent(x.toString(), (key, value) -> (value + 1));
                    results.computeIfAbsent(x.toString(), y -> 1.);
                });
        return (Map<String, Double>) results.entrySet().stream().map(entry->{
            double updatedValue = entry.getValue()/numberOfActions;
            return new HashMap.SimpleEntry<>(entry.getKey(),updatedValue);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
