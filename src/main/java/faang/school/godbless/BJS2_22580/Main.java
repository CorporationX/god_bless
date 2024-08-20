package faang.school.godbless.BJS2_22580;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(1,"Robert");
        User user2 = new User(2,"Sultan");

        List<UserAction> userActions = List.of(
                new UserAction(user1, ActionType.POST, "Пользователь вошёл в систему #stream"),
                new UserAction(user2, ActionType.COMMENT, "Привет, #faang #gg мир!"),
                new UserAction(user1, ActionType.LIKE, "Лайк на пост #gg"),
                new UserAction(user1, ActionType.COMMENT, "я твой хейтер!"),
                new UserAction(user2, ActionType.SHARE, "#faang Пользователь вышел из системы"),
                new UserAction(user2, ActionType.COMMENT, "Я попал в бигтех после бк) #faang")
        );

        System.out.println(UserAction.findTop10MostActiveUser(userActions));
        System.out.println(UserAction.findTop5MostPopularTopics(userActions));
        System.out.println(UserAction.findTop3UsersWithMostCommentsLastMonth(userActions));
        System.out.println(UserAction.calculatePercentageActions(userActions));
    }
}
