package faang.school.godbless.sprint2.BJS2_22569;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Bob", ActionType.POST, LocalDate.now().minusDays(10), "Check out this cool #Java tutorial!"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.now().minusDays(5), "I totally agree with you #Java is awesome!"),
                new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.now().minusDays(20), ""),
                new UserAction(1, "Bob", ActionType.COMMENT, LocalDate.now().minusDays(2), "Thanks for sharing! #Learning"),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.now().minusDays(15), "Here's a new #Tutorial on #Streams"),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.now().minusDays(30), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.now().minusDays(1), "This is very helpful #Java"),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.now().minusDays(25), "My experience with #Java"),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.now().minusDays(7), ""),
                new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.now().minusDays(8), "Nice post! #Java #Programming"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.now().minusDays(3), ""),
                new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.now().minusDays(18), "#Java #Streams are powerful"),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.now().minusDays(12), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.now().minusDays(6), "What do you think about #Java streams?"),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.now().minusDays(4), ""),
                new UserAction(1, "Alice", ActionType.SHARE, LocalDate.now().minusDays(9), ""),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.now().minusDays(2), "Great post! #Learning"),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.now().minusDays(7), "#Java and #Streams"),
                new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.now().minusDays(1), "Learning a lot from this #Java tutorial"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.now().minusDays(10), "")
        );

        System.out.println(UserAction.findTop10ActiveUsers(actions));

        System.out.println(UserAction.getTop5PopularHashtags(actions));

        System.out.println(UserAction.getTop3CommentersLastMonth(actions));

        System.out.println(UserAction.getActionTypePercentages(actions));
    }
}
