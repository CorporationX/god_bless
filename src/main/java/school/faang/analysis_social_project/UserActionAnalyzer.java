package school.faang.analysis_social_project;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class UserActionAnalyzer {
    public List<String> topMostActiveUsers(List<UserAction> actions, int n) {
        Map<String, Long> users = actions.stream()
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
        return users.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topPopularDiscussion(List<UserAction> actions, int n) {
        Map<String, Long> contentsMap = actions.stream()
                .filter(userAction -> userAction.actionType().equals(ActionType.POST)
                        || userAction.actionType().equals(ActionType.COMMENT))
                .flatMap(action -> Arrays.stream(action.content().split(" ")))
                .filter(text -> text.startsWith("#"))
                .map(text -> text.replaceAll("\\W", ""))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        return contentsMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public List<String> topUsersMostCommentsLastMonth(List<UserAction> actions, int n) {
        Map<String, Long> users = actions.stream()
                .filter(action -> action.actionType().equals(ActionType.COMMENT))
                .filter(action -> Period.between(action.actionDate(), LocalDate.now()).getMonths() < 1)
                .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
        return users.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public Map<ActionType, Double> calculatePercentageEachTypeCation(List<UserAction> actions) {
        Map<ActionType, Long> numberTypes = actions.stream()
                .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()));
        long count = actions.size();
        Map<ActionType, Double> percent = new HashMap<>();
        numberTypes.forEach((key, value) -> percent.put(key, value / ((double) count) * 100));
        return percent;
    }
}
