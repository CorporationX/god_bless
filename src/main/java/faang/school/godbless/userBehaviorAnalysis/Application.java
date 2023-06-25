package faang.school.godbless.userBehaviorAnalysis;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<UserAction> userActions = List.of(
                new UserAction(1, "Ivan", ActionType.POST, "2023-02-01", "#Hello"),
                new UserAction(2, "Petr", ActionType.COMMENT, "2023-03-01", "#Hello"),
                new UserAction(3, "Sergey", ActionType.LIKE, "2023-02-01", ""),
                new UserAction(4, "Nikita", ActionType.LIKE, "2023-02-01", ""),
                new UserAction(5, "Egor", ActionType.COMMENT, "2023-06-01", "#world"),
                new UserAction(6, "User6", ActionType.POST, "2023-03-01", "#Hello"),
                new UserAction(7, "User7", ActionType.SHARE, "2023-02-01", ""),
                new UserAction(8, "User8", ActionType.POST, "2023-02-04", "#dev"),
                new UserAction(9, "User9", ActionType.POST, "2023-02-01", "#world"),
                new UserAction(10, "User10", ActionType.LIKE, "2023-02-03", ""),
                new UserAction(11, "User11", ActionType.POST, "2023-02-01", "#Hello"),
                new UserAction(12, "User12", ActionType.POST, "2023-02-02", "#Hello"),
                new UserAction(1, "Ivan", ActionType.COMMENT, "2023-06-01", "#Hello"),
                new UserAction(2, "Petr", ActionType.POST, "2023-06-01", "#world"),
                new UserAction(4, "Nikita", ActionType.POST, "2023-02-01", "#Hello"),
                new UserAction(5, "Egor", ActionType.LIKE, "2023-02-01", ""),
                new UserAction(1, "Ivan", ActionType.POST, "2023-02-01", "#dev"),
                new UserAction(1, "Ivan", ActionType.POST, "2023-02-01", "#happy"),
                new UserAction(1, "Ivan", ActionType.SHARE, "2023-02-01", ""),
                new UserAction(1, "Ivan", ActionType.COMMENT, "2023-06-01", "#world")
        );

        System.out.println(UserActionProcessor.top10ActiveUsers(userActions));
        System.out.println(UserActionProcessor.top5HashTags(userActions));
        System.out.println(UserActionProcessor.top3MonthCommentators(userActions));
        System.out.println(UserActionProcessor.percent(userActions));
    }
}
