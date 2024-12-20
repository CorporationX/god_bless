package school.faang.bjs247359;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = UserActionGenerator.generateRandomActions(50);
        System.out.println(userActions);

        List<String> activeUsers = UserActionAnalyzer.topActiveUsers(userActions);
        System.out.println(activeUsers);

        List<String> topPopularTheme = UserActionAnalyzer.topHashtags(userActions);
        System.out.println(topPopularTheme);

        List<String> topComment = UserActionAnalyzer.topCommentsLastMonth(userActions);
        System.out.println(topComment);

        Map<String, Double> percentAction = UserActionAnalyzer.actionTypePercentages(userActions);
        System.out.println(percentAction);
    }
}
