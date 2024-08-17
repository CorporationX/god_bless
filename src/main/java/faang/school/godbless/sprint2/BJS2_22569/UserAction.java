package faang.school.godbless.sprint2.BJS2_22569;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate date;
    private String content;

    public static List<String> findTop10ActiveUsers(List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTop5PopularHashtags(List<UserAction> actions) {
        return actions.stream()
                .filter(a -> a.getActionType().equals(ActionType.COMMENT) || a.getActionType().equals(ActionType.POST))
                .map(a -> {
                    Pattern pattern = Pattern.compile("#[^\\s]*\\s");
                    Matcher matcher = pattern.matcher(a.getContent());
                    List<String> list = new ArrayList<>();

                    while (matcher.find()) {
                        list.add(matcher.group());
                    }
                    return list;
                })
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(5)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> getTop3CommentersLastMonth(List<UserAction> actions) {
        return actions.stream()
                .filter(u -> u.getDate().isAfter(LocalDate.now().minusMonths(1)))
                .filter(u -> u.getActionType().equals(ActionType.COMMENT))
                .collect(Collectors.groupingBy(UserAction::getName, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> getActionTypePercentages(List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> (double) ((entry.getValue() * 100) / actions.size())));
    }

}
