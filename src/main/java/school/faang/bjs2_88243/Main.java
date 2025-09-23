package school.faang.bjs2_88243;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = UserActionsDataProvider.provideUserActions();

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
