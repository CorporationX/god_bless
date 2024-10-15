package school.faang;

import lombok.Data;

import java.text.CollationElementIterator;
import java.time.chrono.ChronoLocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.time.LocalDate;

@Data
public class UserAction {
    private int id;
    private String name;
    private Set<String> actionType = new HashSet<>(Arrays.asList("post", "comment", "like", "share"));
    private LocalDate actionDate;
    private String content;
    private String action;

    public UserAction(int id, String name, String localActionType, LocalDate actionData, String content) throws IllegalAccessError {
        if (!actionType.contains(localActionType)) {
            throw new IllegalArgumentException("Ошибка типа");
        }
        this.id = id;
        this.content = content;
        this.actionDate = actionData;
        this.action = localActionType;
        this.name = name;
    }

    public static List<String> top10ActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> top5content(List<UserAction> userActions) {
        return userActions.stream()
                .filter(userAction -> userAction.getContent() != null && (userAction.getAction().equals("post") || userAction.getAction().equals("comment")))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> top3Users(List<UserAction> userActions) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActions.stream()
                .filter(userAction -> userAction.getAction().equals("comment") && userAction.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> calculateActiveActions(List<UserAction> userActions) {
        long actions = userActions.size();
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getAction, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> (entry.getValue() * 100.0) / actions
                ));
    }
}
