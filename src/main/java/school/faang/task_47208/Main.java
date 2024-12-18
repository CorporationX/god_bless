package school.faang.task_47208;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<UserAction> actions = CreateUserActions.createListUserActions();

        List<String> topUsers = UserActionAnalyzer.topActiveUsers(actions, "post");
        System.out.println("Топ-10 активных пользователей: " + topUsers);

        System.out.println("----------------------------------------------------");

        List<String> topHashtags = UserActionAnalyzer.topPopularHashtags(actions);
        System.out.println("Топ-5 популярных хэштегов: " + topHashtags);

        System.out.println("----------------------------------------------------");

        List<String> topCommenters = UserActionAnalyzer.topCommentersLastMonth(actions);
        System.out.println("Топ-3 комментаторов за последний месяц: " + topCommenters);

        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
