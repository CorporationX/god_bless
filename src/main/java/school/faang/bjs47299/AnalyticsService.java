package school.faang.bjs47299;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnalyticsService {
    public static List<User> topTen(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(action -> new User(action.userId(), action.userName()), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topTopics(List<UserAction> actions) {
        return actions.stream()
                .filter(action -> action.content() != null && action.type().equals("post") || action.type().equals("comment"))
                .flatMap(action -> Arrays.stream(action.content().split("\\s+")))
                .map(word -> word.replaceAll("!", ""))
                .map(word -> word.replaceAll("\\.", ""))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<User> topUsersLastMonth(List<UserAction> actions) {
        LocalDate exampleDate = LocalDate.of(2024, 11, 1);

        return actions.stream()
                .filter(action -> action.content() != null && action.type().equals("comment"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getKey().actionDate().isAfter(exampleDate.minusMonths(1)))
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .limit(3)
                .map(entry -> new User(entry.getKey().userId(), entry.getKey().userName()))
                .toList();
    }

    public static Map<String, Double> actionTypeRelation(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::type, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() / (double) actions.size()));
    }
}
