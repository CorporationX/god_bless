package school.faang.network;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public List<String> userActivity(List<UserAction> userActions, int limitUser) {
        Map<String, Long> mapUser = userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return mapUser.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limitUser)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public List<String> popularTopicDiscussion(List<UserAction> userActions, char c, int limitComment) {
        return userActions.stream()
                .map(UserAction::getComment)
                .filter(comment -> !comment.isEmpty() && comment.charAt(0) == c)
                .limit(limitComment)
                .collect(Collectors.toList());
    }

    public List<String> maxComment(List<UserAction> userActions, int limitUser) {
        LocalDate date = LocalDate.now().minusMonths(1);
        Map<String, Long> mapUser = userActions.stream()
                .filter(a -> ActionType.COMMENT.equals(a.getType()) && a.getLocalDate().isAfter(date))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return mapUser.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(limitUser)
                .map(Map.Entry::getKey)
                .toList();
    }
    
}
