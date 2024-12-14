package school.faang.task_47144;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = DataInitializer.initData();

        List<String> topUsers = UserActionAnalyzer.topActiveUsers(actions);
        List<String> topHashtags = UserActionAnalyzer.topPopularHashtags(actions);
        List<String> topCommenters = UserActionAnalyzer.topCommentersLastMonth(actions);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + topUsers);
        System.out.println("Топ-5 популярных хэштегов: " + topHashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + topCommenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
