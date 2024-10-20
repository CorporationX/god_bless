package school.faang.bjs2_35616.service;

import lombok.NonNull;
import school.faang.bjs2_35616.model.ActionType;
import school.faang.bjs2_35616.model.Pair;
import school.faang.bjs2_35616.model.UserAction;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(@NonNull List<UserAction> actions) {
        return actions.stream()
                .map(originalUserAction -> {
                    Long countActionByUser = actions.stream()
                            .filter(comparedUserAction -> originalUserAction.getUserId() == comparedUserAction.getUserId())
                            .count();
                    return new Pair<>(countActionByUser, originalUserAction.getUserName());
                })
                .distinct()
                .sorted(Comparator.comparing(Pair::getOne, Comparator.reverseOrder()))
                .limit(10)
                .map(Pair::getTwo)
                .toList();
    }

    public static List<String> topPopularHashtags(@NonNull List<UserAction> actions) {
        return actions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.POST) || userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> !(userAction.getContent().isEmpty()))
                .flatMap(originalUserAction -> {
                    String[] split = originalUserAction.getContent().split("[^\\w#]+");
                    return Arrays.stream(split)
                            .filter(word -> word.matches("#[A-Za-z0-9]+"));
                })
                .distinct()
                .map(hashtag -> {
                    long countContentByHashtag = actions.stream()
                            .filter(userAction -> userAction.getActionType().equals(ActionType.POST) || userAction.getActionType().equals(ActionType.COMMENT))
                            .filter(userAction -> !(userAction.getContent().isEmpty()))
                            .flatMap(userAction -> Arrays.stream(userAction.getContent().split("[^\\w#]+"))
                                    .filter(hashtag::equals)).count();
                    return new Pair<>(countContentByHashtag, hashtag);
                })
                .sorted(Comparator.comparing(Pair::getOne, Comparator.reverseOrder()))
                .limit(5)
                .map(Pair::getTwo)
                .toList();
    }

    public static List<String> topCommentersLastMonth(@NonNull List<UserAction> actions) {
        return actions.stream()
                .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                .filter(userAction -> ChronoUnit.DAYS.between(userAction.getActionDate(), LocalDate.now()) >= 0 &&
                        ChronoUnit.DAYS.between(userAction.getActionDate(), LocalDate.now()) <= 30)
                .map(originalUserAction -> {
                    Long countActionCommentByUser = actions.stream()
                            .filter(userAction -> userAction.getActionType().equals(ActionType.COMMENT))
                            .filter(userAction -> ChronoUnit.DAYS.between(userAction.getActionDate(), LocalDate.now()) >= 0 &&
                                    ChronoUnit.DAYS.between(userAction.getActionDate(), LocalDate.now()) <= 30)
                            .filter(comparedUserAction -> originalUserAction.getUserId() == comparedUserAction.getUserId())
                            .count();
                    return new Pair<>(countActionCommentByUser, originalUserAction.getUserName());
                })
                .distinct()
                .sorted(Comparator.comparing(Pair::getOne, Comparator.reverseOrder()))
                .limit(3)
                .map(Pair::getTwo)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(@NonNull List<UserAction> actions) {
        return actions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType))
                .entrySet().stream()
                .collect(Collectors.toMap(actionTypeListEntry -> actionTypeListEntry.getKey().name(),
                        actionTypeListEntry -> Math.round(((double) actionTypeListEntry.getValue().size() / actions.size()) * 100 * 10) / 10.0
                ));
    }
}
