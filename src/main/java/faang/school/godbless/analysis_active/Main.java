package faang.school.godbless.analysis_active;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.analysis_active.UserActionAnalyzer.calculateActionTypePercentages;
import static faang.school.godbless.analysis_active.UserActionAnalyzer.findTop10MostActiveUsers;
import static faang.school.godbless.analysis_active.UserActionAnalyzer.findTop3UsersWithMostCommentsLastMonth;
import static faang.school.godbless.analysis_active.UserActionAnalyzer.findTop5PopularTopics;

public class Main  {
    public static void main(String[] args) {
        List<UserAction> userActions = new ArrayList<>();
        userActions.add(new UserAction(1, "Max", ActionType.LIKE,
                LocalDate.now().minusDays(1), "Like post"));

        userActions.add(new UserAction(2, "Tom", ActionType.LIKE,
                LocalDate.now().minusDays(2), "Like post"));
        userActions.add(new UserAction(2, "Tom", ActionType.POST,
                LocalDate.now().minusDays(1), "Create post"));
        userActions.add(new UserAction(2, "Tom", ActionType.COMMENT,
                LocalDate.now(), "Write comment"));

        userActions.add(new UserAction(3, "Mark", ActionType.COMMENT,
                LocalDate.now().minusDays(4), "Write comment"));
        userActions.add(new UserAction(3, "Mark", ActionType.COMMENT,
                LocalDate.now(), "Write comment"));

        userActions.add(new UserAction(4, "Ann", ActionType.SHARE,
                LocalDate.now(), "Share the post"));

        userActions.add(new UserAction(5, "Bob", ActionType.LIKE,
                LocalDate.now().minusWeeks(1), "Like post"));

        userActions.add(new UserAction(6, "Timmy", ActionType.LIKE,
                LocalDate.now().minusMonths(1), "Like post"));
        userActions.add(new UserAction(6, "Timmy", ActionType.LIKE,
                LocalDate.now().minusDays(3), "Like post"));
        userActions.add(new UserAction(6, "Timmy", ActionType.SHARE,
                LocalDate.now(), "Share the post"));

        userActions.add(new UserAction(7, "Nina", ActionType.SHARE,
                LocalDate.now(), "Share the post"));
        userActions.add(new UserAction(7, "Nina", ActionType.POST,
                LocalDate.now(), "Create post"));

        userActions.add(new UserAction(8, "Alex", ActionType.COMMENT,
                LocalDate.now().minusDays(1), "Write comment"));

        userActions.add(new UserAction(9, "Serj", ActionType.SHARE,
                LocalDate.now(), "Share the post"));
        userActions.add(new UserAction(9, "Serj", ActionType.SHARE,
                LocalDate.now(), "Share the post"));
        userActions.add(new UserAction(9, "Serj", ActionType.LIKE,
                LocalDate.now(), "Like post"));
        userActions.add(new UserAction(9, "Serj", ActionType.LIKE,
                LocalDate.now(), "Like post"));
        userActions.add(new UserAction(9, "Serj", ActionType.SHARE,
                LocalDate.now(), "Share post"));

        userActions.add(new UserAction(10, "John", ActionType.LIKE,
                LocalDate.now(), "Like post"));

        System.out.println("10 самых активных пользователей: " + findTop10MostActiveUsers(userActions));

        List<String> posts = List.of(
                "Зацени мои новые классные #фото с отпуска! #пляж #закат #море",
                "Эта #книга просто великолепна. Рекомендую! #чтение",
                "Вчерашний #концерт был просто взрыв мозга! Скоро выложу кучу #фото. #музыка"
        );
        List<String> comments = List.of(
                "Клаасные #фото получились! #пляж",
                "Мне тоже нравится эта #книга. #чтение",
                "Согласен, #концерт был потрясный. Просто топчик! #музыка"
        );
        System.out.println("5 популярных #: " + findTop5PopularTopics(posts, comments));

        System.out.println("Топ-3 пользователей, которые оставили наибольшее количество комментариев в последний месяц: "
                + findTop3UsersWithMostCommentsLastMonth(userActions));

        System.out.println("Процент для каждого типа действия: " + calculateActionTypePercentages(userActions));
    }
}
