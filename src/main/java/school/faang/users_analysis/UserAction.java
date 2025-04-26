package school.faang.users_analysis;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserAction {
    private int id;
    private String name;
    private ActionType actionType;
    private LocalDate actionDate;
    private String content;

    public UserAction(int id, String name, ActionType actionType, LocalDate actionDate, String content) {
        this.id = id;
        this.name = name;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;

    }

    static List<String> topNumUserActions(List<UserAction> userActions, int x) {
        return userActions.stream()
                .filter(Objects::nonNull)
                .filter(ua -> ua.getName() != null)
                .filter(ua -> ua.getActionType() != null)
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(
                                UserAction::getName,
                                Collectors.counting()
                        ),
                        map -> map.entrySet().stream()
                                .sorted(Map.Entry.<String, Long>comparingByValue()
                                        .reversed()
                                        .thenComparing(Map.Entry.comparingByKey()))
                                .limit(Math.max(x, 0))
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList())
                ));
    }

    static List<String> topNumUserContent(List<UserAction> userActions, int x) {

        return userActions.stream()
                .filter(Objects::nonNull)
                .map(UserAction::getContent)
                .filter(Objects::nonNull)
                .flatMap(content -> Arrays.stream(content.split("\\s+")))
                .filter(word -> word.startsWith("#"))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        hashtag -> hashtag,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(Math.max(x, 0))
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topNumCommentersLastMonth(List<UserAction> actions, int x, LocalDate lastMonth) {
        LocalDate date = lastMonth.minusMonths(1);

        return Optional.ofNullable(actions).orElse(Collections.emptyList()).stream()
                .filter(ua -> ua != null
                        && ua.getActionType() == ActionType.COMMENT
                        && ua.getActionDate() != null
                        && ua.getActionDate().isAfter(date))
                .collect(Collectors.groupingBy(
                        UserAction::getName,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(Math.max(x, 0))
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<ActionType, Double> getActionStats(List<UserAction> actions) {


        return actions.stream()
                .filter(ua -> ua != null && ua.getActionType() != null)
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                count -> (double) Math.round((float) (count * 10000)
                                        / actions.stream().filter(Objects::nonNull).count()) / 100
                        )
                ));
    }
}
