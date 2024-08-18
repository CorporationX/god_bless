package faang.school.godbless.BJS2_22600;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalyzeActionsUsers {
    public List<Long> findTopTenUsers(List<UserAction> userActionList) {
        return userActionList.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public List<String> findTopFiveThemes(List<UserAction> userActionList) {
        return userActionList.stream()
                .filter(action -> action.getActionType() == ActionType.POST || action.getActionType() == ActionType.COMMENT)
                .map(UserAction::getContent)
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                .filter(word -> word.startsWith("#") && word.length() > 1)
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public List<Long> findTopThreeUsersByComments(List<UserAction> userActionList) {
        return userActionList.stream()
                .filter(action -> action.getActionType() == ActionType.COMMENT)
                .filter(action -> action.getActionDate().isAfter(LocalDateTime.now().minusMonths(1)))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
    public Map<ActionType, Double> findPercentActions(List<UserAction> userActionList) {
        double totalActions = userActionList.size();
        return userActionList.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> (count / totalActions) * 100
                        )
                ));
    }

}
