package faang.school.godbless.sprint2.activityAnalytics;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserAction {

    private String id;
    private ActionType actionType;
    private LocalDateTime actionDate;
    private String content;

    public UserAction(String id, ActionType actionType, LocalDateTime actionDate, String content) {
        this.id = id;
        this.actionType = actionType;
        this.actionDate = actionDate;
        this.content = content;
    }

    public static List<Map<String, Long>> getTheMostActiveUsersByAction(List<UserAction> userActions, ActionType actionType, Integer amountUsers) {
        if (!ValidationUtils.isValidCollection(userActions) || actionType == null || amountUsers == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return userActions.stream()
                .filter(userAction -> Objects.nonNull(userAction) && userAction.getActionType().equals(actionType))
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(e -> Map.ofEntries(Map.entry(e.getKey(), e.getValue())))
                .limit(amountUsers)
                .toList();
    }

    public static List<Map<String, Long>> getTheMostPopularThemes(List<UserAction> userActions, Integer amountThemes) {
        if (!ValidationUtils.isValidCollection(userActions) || amountThemes == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return userActions.stream()
                .filter(userAction -> Objects.nonNull(userAction) && (userAction.getActionType().equals(ActionType.POST)
                        || userAction.getActionType().equals(ActionType.COMMENT)))
                .flatMap(userAction -> Arrays.stream(userAction.getContent().split(" ")))
                .filter(userContentWord -> userContentWord.startsWith("#"))
                .collect(Collectors.groupingBy(userContentWordWithHashTag -> userContentWordWithHashTag, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(e -> Map.ofEntries(Map.entry(e.getKey(), e.getValue())))
                .toList();
    }

    public static List<Map<String, Long>> getTheMostActiveByCommentsLastMonth(List<UserAction> userActions, Integer amountUsers) {
        if (!ValidationUtils.isValidCollection(userActions) || amountUsers == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        LocalDateTime limitDateTime = LocalDateTime.now().minusMonths(1);

        return userActions.stream()
                .filter(userAction -> Objects.nonNull(userAction) && userAction.getActionType().equals(ActionType.COMMENT)
                        && userAction.getActionDate().isAfter(limitDateTime))
                .collect(Collectors.groupingBy(
                        UserAction::getId,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(e -> Map.ofEntries(Map.entry(e.getKey(), e.getValue())))
                .limit(amountUsers)
                .toList();
    }

    public static Map<ActionType, Double> getAllActivitiesInPercent(List<UserAction> userActions) {
        if (!ValidationUtils.isValidCollection(userActions)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return userActions.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        UserAction::getActionType,
                        Collectors.collectingAndThen(
                                Collectors.counting(),
                                amount -> (double) amount / userActions.size() * 100
                        )
                ));
    }
}
