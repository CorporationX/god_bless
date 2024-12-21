package faang.school.godbless.sprint_2.task_47370;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        UserAction userAction1 = new UserAction(1, "Pavel", ActionType.POST, "Лучшее #лето в моей жизни! #живу_жизнь");

        UserAction userAction2 = new UserAction(2, "Olga", ActionType.SHARE, "Очень круто!");

        UserAction userAction3 = new UserAction(1, "Pavel", ActionType.LIKE, null);

        UserAction userAction4 = new UserAction(3, "Sergey", ActionType.COMMENT, "#полезно!");

        UserAction userAction5 = new UserAction(2, "Olga", ActionType.POST,
                "Здорово провела время на корпоративе! #корпоратив #живу_жизнь #лето");

        UserAction userAction6 = new UserAction(1, "Pavel", ActionType.COMMENT,
                "Меня поцарапал кот :( #бесконечная_боль #милый_котик");

        UserAction userAction7 = new UserAction(4, "Elena", ActionType.COMMENT, "Почему нет комментариев???");

        List<UserAction> actions = new ArrayList<>();
        actions.add(userAction1);
        actions.add(userAction2);
        actions.add(userAction3);
        actions.add(userAction4);
        actions.add(userAction5);
        actions.add(userAction6);
        actions.add(userAction7);

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
