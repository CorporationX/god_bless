package faang.school.godbless.BJS2_22575;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Social {

    private static final Long MAX_THEMES_SIZE = 5L;
    private static final Long MAX_USERS_SIZE = 10L;
    private static final Long MAX_USERS_PER_MONTH_SIZE = 3L;

    public static Map<String, Long> findTop10Users(List<UserAction> userActions) {
        var temp = userActions.stream().collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return temp.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(MAX_USERS_SIZE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Long> findTop5Themes(List<UserAction> userActions) {
        String regex = "#\\S*";
        Pattern pattern = Pattern.compile(regex);
        var temp =  userActions.stream().collect(Collectors.groupingBy(userAction -> {
            Matcher matcher = pattern.matcher(userAction.getContent());
            if (matcher.find()) {
                return matcher.group();
            }
            else return "null";
        }, Collectors.counting()));

        return temp.entrySet().stream()
                .filter(entry -> !entry.getKey().equals("null"))
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(MAX_THEMES_SIZE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<String, Long> lastMonthTop3UsersMadeComments(List<UserAction> userActions) {
        var temp= userActions.stream()
                .filter(userAction -> userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(1L)))
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()));
        return temp.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                .limit(MAX_USERS_PER_MONTH_SIZE)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Map<ActionType, String> percentOfActions(List<UserAction> userActions) {
        var temp = userActions.stream().collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()));
        return temp.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> String.format("%.2f%%", Double.valueOf(entry.getValue()) * 100 / (double) userActions.size())));
    }
}
