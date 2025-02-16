package school.faang.sprint.second.socialactivity;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public final class UserActionAnalyzer {
    private UserActionAnalyzer() {
    }

    public static List<String> topActiveUsers(@NonNull List<UserAction> userActions, int top) {
        Map<String, Integer> topActiveUsersMap =  userActions.stream()
                .collect(Collectors.toMap(
                        UserAction::getName,
                        action -> 1,
                        Integer::sum,
                        TreeMap::new
                ));

        return mapToListWithSorting(topActiveUsersMap, top);
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> userActions, int top) {
        Map<String, Integer> topPopularHashtagsMap = userActions.stream()
                .filter(userAction -> getHashTag(userAction).isPresent())
                .collect(Collectors.toMap(
                        userAction -> getHashTag(userAction).get(),
                        action -> 1,
                        Integer::sum,
                        TreeMap::new
                ));

        return mapToListWithSorting(topPopularHashtagsMap, top);
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> userActions, int top) {
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = LocalDate.of(today.getYear(), today.getMonth(), 1);
        Map<String, Integer> topCommentersLastMonthMap = userActions.stream()
                .filter(userAction -> !userAction.getContent().isBlank()
                        && !userAction.getActionDate().isBefore(startOfMonth))
                .collect(Collectors.toMap(
                        UserAction::getName,
                        action -> 1,
                        Integer::sum,
                        TreeMap::new
                ));

        return mapToListWithSorting(topCommentersLastMonthMap, top);
    }

    public static Map<String, Double> actionTypePercentages(@NonNull List<UserAction> userActions) {
        Map<String, Double> actionTypePercentageMap = userActions.stream()
                .collect(Collectors.toMap(
                        userAction -> userAction.getActionType().toString(),
                        actionType -> 1.0,
                        Double::sum,
                        HashMap::new
                ));

        actionTypePercentageMap.entrySet()
                .forEach(entry ->
                        entry.setValue((double) Math.round(entry.getValue() / userActions.size() * 100 * 100) / 100.0));

        return actionTypePercentageMap;
    }

    private static List<String> mapToListWithSorting(Map<String, Integer> map, int top) {
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(top)
                .map(Map.Entry::getKey)
                .toList();
    }

    private static Optional<String> getHashTag(@NonNull UserAction userAction) {
        String userContent = userAction.getContent();
        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(userContent);

        if (matcher.find()) {
            return Optional.of(matcher.group());
        }
        return Optional.empty();
    }
}
