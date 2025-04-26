package school.faang.bjs2_70955;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionService {

    private UserActionService() {
    }

    public static List<String> getTopUsers(List<UserAction> userActions, int count) {

        return userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopHashtags(List<UserAction> userActions, int count) {

        return userActions.stream()
                .filter(action -> action.getComment().contains("#"))
                .collect(Collectors.groupingBy(
                        action ->
                                Pattern.compile("#[A-Za-z0-9-_]+")
                                        .matcher(action.getComment())
                                        .results()
                                        .map(x -> x.group(0))
                                        .toList()
                                        .get(0),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(count)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTopUsersByCommentsLastMonth(List<UserAction> userActions) {

        return userActions.stream()
                .filter(action -> !action.getComment().isEmpty())
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<Map<ActionType, Long>> getActionTypePercentage(List<UserAction> userActions) {

        return userActions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .map(x -> Map.of(
                        x.getKey(),
                        x.setValue(x.getValue() * 100 / userActions.size()))
                )
                .toList();
    }
}
