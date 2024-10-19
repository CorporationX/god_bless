package school.faang.bjs2_35616.service;

import school.faang.bjs2_35616.model.ActionType;
import school.faang.bjs2_35616.model.Pair;
import school.faang.bjs2_35616.model.UserAction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class UserActionAnalyzer {
    public static List<String> topActiveUsers(List<UserAction> actions) {
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

    public static List<String> topPopularHashtags(List<UserAction> actions) {
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

    //                .flatMap(originalUserAction -> {
//                    String[] split = originalUserAction.getContent().split("[^\\w#]+");
//                    return Arrays.stream(split)
//                            .filter(word -> word.matches("#[A-Za-z0-9]+"))
//                            .map(hashtag -> {
//                                long countContentByHashtag = actions.stream()
//                                        .filter(userAction -> userAction.getContent().contains(hashtag))
//                                        .count();
//                                return new Pair<>(countContentByHashtag, hashtag);
//                            }).toList();
//
//                })
    public static List<String> topCommentersLastMonth(List<UserAction> actions) {

        return null;
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {

        return null;
    }
}
