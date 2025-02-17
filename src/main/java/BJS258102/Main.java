package BJS258102;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;

import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        ActionService actionService = new ActionService();

        List<UserAction> userActions = Arrays.asList(
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 9,
                        2), "I totally agree with #newfeature ."),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 9,
                        3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2024, 9,
                        4), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2024, 9,
                        5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2024, 9,
                        6), ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2024, 9,
                        7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2024, 9,
                        8), "Thanks for sharing #project !")

        );
        userActions.forEach(actionService::addUserAction);

        System.out.println(actionService.getTopMostActivity(actionService.getUserActionHashMap(), 5));

        System.out.println(actionService.getTopHashtag(actionService.getUserActionHashMap(), 3));

        System.out.println(actionService.getTopComment(actionService.getUserActionHashMap(), 3));

        System.out.println(actionService.getPercentage(actionService.getUserActionHashMap()));
    }
}
