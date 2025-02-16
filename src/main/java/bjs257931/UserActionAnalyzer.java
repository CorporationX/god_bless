package bjs257931;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserActionAnalyzer {

    public static List<String> getTopActiveUsers(List<UserAction> actions, int numberActionTypes) {
        Map<String, Long> nameToNumberNames = Objects.requireNonNull(actions).stream()
                .filter(action -> Objects.nonNull(action.getName()))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return nameToNumberNames.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(numberActionTypes)
                .map(Map.Entry::getKey).toList();
    }

    public static List<String> getTopPopularHashtags(List<UserAction> actions, int numberActionTypes) {
        Map<String, Long> tagsToNumberTags = Objects.requireNonNull(actions).stream()
                .filter(action ->
                        Objects.nonNull(action.getContent())
                                && !action.getContent().isBlank()
                                && action.getActionType().equals(ActionType.POST)
                                || (action.getActionType().equals(ActionType.COMMENT)))
                .map(UserAction::getContent)
                .flatMap(string -> Arrays.stream(string.split("\\s")))
                .filter(string -> string.startsWith("#"))
                .map(string -> {
                    String lastSymbolInString = String.valueOf(string.charAt(string.length() - 1));
                    if (lastSymbolInString.matches("[,\\.!?]")) {
                        string = new StringBuilder(string).deleteCharAt(string.length() - 1).toString();
                    }
                    return string;
                })
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return tagsToNumberTags.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey).limit(numberActionTypes).toList();
    }

    public static List<String> getTopCommentersLastMonth(List<UserAction> actions, int numberActionTypes) {
        Map<String, Long> userToNumberComments =
                Objects.requireNonNull(actions).stream()
                        .filter(action -> Objects.requireNonNull(action.getActionType()).equals(ActionType.COMMENT)
                                && action.getActionDate().isAfter(LocalDate.now().minusMonths(1))
                                && Objects.nonNull(action.getName()))
                        .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));

        return userToNumberComments.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(numberActionTypes).map(Map.Entry::getKey).toList();
    }

    public static Map<ActionType, Double> getActionTypePercentages(List<UserAction> actions) {
        long numberActionTypes = Objects.requireNonNull(actions).stream()
                .filter(action -> Objects.nonNull(action.getActionType())).count();
        Map<ActionType, Long> typeToNumberTypes = actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return typeToNumberTypes.entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey,
                        typeToNumberType -> (typeToNumberType.getValue() * 100.0) / numberActionTypes));
    }
}
