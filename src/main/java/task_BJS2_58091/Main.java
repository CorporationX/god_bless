package task_BJS2_58091;

import java.util.List;
import java.util.Map;

public class Main {
    private static final TestData TEST_DATA = new TestData();
    private static final List<UserAction> ACTIONS = TEST_DATA.getActions();

    public static void main(String[] args) {

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(ACTIONS, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(ACTIONS, 5);
//        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(ACTIONS, 3);
//        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(ACTIONS);

        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
//        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
//        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
