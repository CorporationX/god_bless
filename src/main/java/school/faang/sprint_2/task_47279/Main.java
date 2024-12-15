package school.faang.sprint_2.task_47279;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<UserAction> actions = UserActionData.getData();

        UserActionService userActionService = new UserActionService();
        List<String> topUsers = userActionService.geTopActiveUsers(actions);
        List<String> topTags = userActionService.getPopularTags(actions);
        List<String> topCommenters = userActionService.getTopMonthCommenters(actions);
        Map<String, Double> actionPercentages = userActionService.getActionTypePercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + topUsers);
        System.out.println("Топ-5 популярных хэштегов: " + topTags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + topCommenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
