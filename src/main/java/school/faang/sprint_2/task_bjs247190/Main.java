package school.faang.sprint_2.task_bjs247190;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = TestUserActionsData.getActions();

        List<String> topUsers = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> topHashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> topCommenters = UserActionAnalyzer.topCommentersLastMonth(actions, "comment", 3);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + topUsers);
        System.out.println("Топ-5 популярных хэштегов: " + topHashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + topCommenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
