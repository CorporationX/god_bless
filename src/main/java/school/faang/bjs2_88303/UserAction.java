package school.faang.bjs2_88303;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@Setter
public class UserAction {
    private int userId;
    private String userName;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public static List<String> getTopUsers(List<UserAction> actions, int requiredCount) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getUserName, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(requiredCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getTopHashtag(List<UserAction> actions, int requiredCount) {
        return actions.stream()
                .map(UserAction::getContent)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(con -> con.contains("#"))
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(requiredCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> getTopCommentators(List<UserAction> actions, int requiredCount) {
        return actions.stream()
                .filter(type -> type.actionType == ActionType.COMMENT)
                .collect(Collectors.groupingBy(
                        UserAction::getUserName, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(requiredCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static Map<ActionType, Long> countPercentOfActionTypes(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(
                        UserAction::getActionType, Collectors.counting()
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        entry -> (100 / actions.size() * entry.getValue())));
    }
}
