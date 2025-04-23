package school.faang.sprinttwo.analysisofuseractivity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = generateTestData();

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.calculateActionPercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }

    private static List<UserAction> generateTestData() {
        List<UserAction> actions = new ArrayList<>();
        actions.add(new UserAction(1, "user1", ActionType.POST,
                LocalDate.of(2023, 10, 15), "Первый пост #java #spring"));
        actions.add(new UserAction(1, "user1", ActionType.POST,
                LocalDate.of(2022, 10, 15), "Первый пост #java #spring"));
        actions.add(new UserAction(1, "user1", ActionType.POST,
                LocalDate.of(2021, 10, 15), "Первый пост #java #spring"));
        actions.add(new UserAction(1, "user1", ActionType.POST,
                LocalDate.of(2020, 10, 15), "Первый пост #java #spring"));

        actions.add(new UserAction(2, "user2", ActionType.COMMENT,
                LocalDate.now().minusMonths(1), "Отличный пост! #java"));
        actions.add(new UserAction(2, "user2", ActionType.COMMENT,
                LocalDate.of(2025, 10, 16), "Отличный пост! #java"));
        actions.add(new UserAction(2, "user2", ActionType.COMMENT,
                LocalDate.of(2025, 10, 16), "Отличный пост! #java"));

        actions.add(new UserAction(3, "user1", ActionType.LIKE,
                LocalDate.of(2023, 10, 17), null));
        actions.add(new UserAction(3, "user1", ActionType.LIKE,
                LocalDate.of(2022, 10, 17), null));

        actions.add(new UserAction(4, "user3", ActionType.SHARE,
                LocalDate.of(2023, 9, 1), "Репост #news"));

        actions.add(new UserAction(5, "user2", ActionType.COMMENT,
                LocalDate.of(2023, 10, 18), "Спасибо за информацию #help"));

        actions.add(new UserAction(6, "user4", ActionType.POST,
                LocalDate.of(2023, 10, 20), "Новости #news #java"));

        actions.add(new UserAction(7, "user5", ActionType.COMMENT,
                LocalDate.of(2023, 10, 21), "Iнтересно #discussion"));

        actions.add(new UserAction(8, "user1", ActionType.POST,
                LocalDate.of(2023, 10, 22), "Обновление #spring #java"));

        actions.add(new UserAction(9, "user2", ActionType.LIKE,
                LocalDate.of(2023, 10, 23), null));

        actions.add(new UserAction(10, "user3", ActionType.COMMENT,
                LocalDate.now().minusMonths(1), "Отлично! #spring"));
        actions.add(new UserAction(10, "user3", ActionType.COMMENT,
                LocalDate.now().minusMonths(1), "Супер! #sSpring"));
        actions.add(new UserAction(10, "user3", ActionType.COMMENT,
                LocalDate.now().minusMonths(1), "Greate! #spring"));

        actions.add(new UserAction(11, "user1", ActionType.SHARE,
                LocalDate.of(2023, 10, 25), "Репост #java"));

        actions.add(new UserAction(12, "user6", ActionType.POST,
                LocalDate.of(2023, 10, 26), "Финал #contest #winner"));
        return actions;
    }
}