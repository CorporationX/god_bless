package school.faang.task58032;

import school.faang.task58032.service.UserAction;
import school.faang.task58032.service.UserActionAnalyzer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = new ArrayList<>();// данные о действиях пользователей

        // Получение результатов
        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        // Вывод результатов
        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}