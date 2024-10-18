package school.faang.bjs2_35616.service;

import school.faang.bjs2_35616.model.Pair;
import school.faang.bjs2_35616.model.UserAction;

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
        return null;
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions) {

        return null;
    }

    public Map<String, Double> actionTypePercentages(List<UserAction> actions) {

        return null;
    }
}
