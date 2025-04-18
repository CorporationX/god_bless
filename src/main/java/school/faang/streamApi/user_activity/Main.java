package school.faang.streamApi.user_activity;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = ListOfUsers.getActions();

        List<String> top3Users = UserActivityAnalyzer.getMostActiveUsers(actions, 3);
        List<String> top5Hashtags = UserActivityAnalyzer.getMostPopularTags(actions, 5);
        List<String> top3Commenters = UserActivityAnalyzer.getTopCommentersLastMonth(actions, 3);
        Map<ActionType, String> actionPercentages = UserActivityAnalyzer.getActionPercentage(actions);

        System.out.println("Топ-10 активных пользователей: " + top3Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
