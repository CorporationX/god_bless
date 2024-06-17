package faang.school.godbless.stream.user_action_analyze;


import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static faang.school.godbless.stream.user_action_analyze.ActionType.*;

public class UserActionAnalyze {
    private static final int TOP_POPULAR_USERS = 10;
    private static final int TOP_ACTIVE_USERS_BY_COMMENT = 10;
    private static final int TOP_POPULAR_CONTENT = 5;


    public List<Integer> getTenMostPopularUsers(@NonNull List<UserAction> userActions) {
        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(TOP_POPULAR_USERS)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }


    public List<String> getMostPopularContents(@NonNull List<UserAction> userActions) {
        Map<String, Long> popularContent = userActions.stream()
                .filter(userAction -> isPost(userAction) || isComment(userAction))
                .filter(this::containsHashtag)
                .collect(Collectors.toMap(UserAction::getContent, this::countHashtag, (content1, content2) -> content1));

        return popularContent.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(TOP_POPULAR_CONTENT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    private long countHashtag(UserAction userAction) {
        return Arrays.stream(userAction.getContent().split(" "))
                .filter(str -> str.matches("^#\\w+"))
                .count();
    }

    private boolean containsHashtag(UserAction userAction) {
        return userAction.getContent().contains("#");
    }

    private boolean isPost(UserAction userAction) {
        return userAction.getActionType().equals(POST);
    }

    public List<Integer> getMostActiveUsersByLastMonth(@NonNull List<UserAction> userActions, int monthCount) {

        Map<Integer, Long> popularUsersByCommentMonth = userActions.stream()
                .filter(this::isComment)
                .filter(userAction -> inLastMonth(userAction, monthCount))
                .collect(Collectors.groupingBy(UserAction::getId, Collectors.counting()));

        return popularUsersByCommentMonth.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(TOP_ACTIVE_USERS_BY_COMMENT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private boolean isComment(UserAction userAction) {
        return userAction.getActionType().equals(COMMENT);
    }

    private boolean inLastMonth(UserAction userAction, int monthCount) {
        return userAction.getActionDate().isAfter(LocalDateTime.now().minusMonths(monthCount));
    }

    public Map<ActionType, Double> getActionPercentage(@NonNull List<UserAction> userActions) {

        return userActions.stream()
                .collect(Collectors.groupingBy(UserAction::getActionType, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() * 100.0 / userActions.size()));
    }
}
