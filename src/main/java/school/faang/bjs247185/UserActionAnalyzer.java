package school.faang.bjs247185;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public List<String> topActiveUsers(List<UserAction> actions) {
        validate(actions);
        Map<String, List<UserAction>> users = actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getName
                ));

        return users.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().size()))
                .limit(10)
                .distinct()
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularHashtags(List<UserAction> actions) {
        validate(actions);
        return actions.stream()
                .filter(action ->
                        action.getContent() != null
                                && action.getActionType().equals("post")
                                || action.getActionType().equals("comment"))
                .flatMap(action -> Arrays.stream(
                        Objects.requireNonNull(action.getContent()).split("\\\\\\\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> topCommentersLastMonth(List<UserAction> actions) {
        validate(actions);
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return actions.stream()
                .filter(action -> action.getActionType().equals("comment")
                        && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        validate(actions);
        int total = actions.size();

        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> (e.getValue() * 100.0 / total)
                ));
    }

    private void validate(Object object) {
        if (object == null) {
            throw new NullPointerException("Argument must be not null");
        }
    }
}
