package bjs2_35433;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = UserActionsSupplier.getActions();

        List<String> topActiveUsers = UserActionAnalyzer.topActiveUsers(actions);
        List<String> topPopularHashtags = UserActionAnalyzer.topPopularHashtags(actions);
        List<String> topCommentersLastMonth = UserActionAnalyzer.topCommentersLastMonth(actions);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionPercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + topActiveUsers);
        System.out.println("Топ-5 популярных хэштегов: " + topPopularHashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + topCommentersLastMonth);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
