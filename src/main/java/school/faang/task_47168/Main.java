package school.faang.task_47168;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = UserActionGenerator.generateRandomActions(20);

        UserActionAnalyzer analyzer = new UserActionAnalyzer();

        System.out.println("Топ-10 активных пользователей: " + analyzer.topActiveUsers(actions));
        System.out.println("Топ-5 популярных хэштегов: " + analyzer.topPopularHashtags(actions));
        System.out.println("Топ-3 комментаторов за последний месяц: " + analyzer.topCommentersLastMonth(actions));
        System.out.println("Процент действий по типам: " + analyzer.actionTypePercentages(actions));
    }
}