package Analyze;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public List<String> findTop10ActiveUsers(List<UserAction> userActions) {
        Map<String, Long> userActivityMap = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return userActivityMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> findTop5PopularTopics(List<UserAction> userActions) {
        Map<String, Long> hashtagCountMap = userActions.stream()
                .filter(action -> action.getActionType().equals("post") || action.getActionType().equals("comment"))
                .flatMap(action -> Arrays.stream(action.getContent().split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        return hashtagCountMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> findTop3CommentingUsersLastMonth(List<UserAction> userActions) {

        Map<String, Long> commentingUsersLastMonth = userActions.stream()
                .filter(action -> action.getActionType().equals("comment"))
                .filter(action -> action.getActionDate().isAfter(LocalDate.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getUserName, Collectors.counting()));

        return commentingUsersLastMonth.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> calculateActionPercentage(List<UserAction> userActions) {
        long totalActions = userActions.size();

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType,
                        Collectors.collectingAndThen(Collectors.counting(), count -> (int) Math.round((double) count / totalActions * 100))));
    }

}
