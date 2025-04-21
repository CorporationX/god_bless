package school.faang.stream2.useractivityinsocialnet;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UsersActionList usersActionList = new UsersActionList();
        UserActionAnalyzer userActionAnalyzer = new UserActionAnalyzer();

        List<String> top10Users = userActionAnalyzer.makeListOfTopActiveUsers(usersActionList, 10);
        List<String> top5Hashtags = userActionAnalyzer.makeListOfTopPopularHashtags(usersActionList, 5);
        List<String> top3Commenters = userActionAnalyzer.makeListOfTopCommentersLastMonth(usersActionList, 3);
        Map<String, Double> actionPercentages = userActionAnalyzer.makeMapOfActionTypePercentages(usersActionList);

        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
