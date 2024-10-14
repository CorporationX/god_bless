package Social;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class UserOperation {
    public List<String> topActiveUsers(List<UserAction> userActionList) {
        return userActionList.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularTopics(List<UserAction> userActionList) {
        return userActionList.stream()
                .filter(action -> action.getContent() != null && action.getActionType().equals("post") || action.getActionType().equals("comment"))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> userWhoLeftMoreComments(List<UserAction> userActionList) {
        LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
        return userActionList.stream()
                .filter(action -> action.getActionType().equals("comment") && action.getActionDate().isAfter(oneMonthAgo))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<String, Double> сalculatePercentage(List<UserAction> userActionList) {
       long total = userActionList.size();
       return userActionList.stream()
               .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
               .entrySet().stream()
               .collect(Collectors.toMap(Map.Entry::getKey, value->Math.round(((value.getValue() * 100.0) / total) * 100.0) / 100.0));
    }
}
