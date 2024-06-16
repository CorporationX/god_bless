package ActivityAnalysis;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> userActions = Arrays.asList(
                new UserAction(4, "Alice", "post", new Date(), "#home"),
                new UserAction(2, "Bob", "comment", new Date(), "#home"),
                new UserAction(4, "Alice", "post", new Date(), "#office"),
                new UserAction(3, "Charlie", "comment", new Date(), "#office"),
                new UserAction(2, "Bob", "post", new Date(), "#home"),
                new UserAction(1, "Rob", "comment", new Date(), "#home"),
                new UserAction(4, "Alice", "comment", new Date(), "#home")
        );
        Methods.findTopTenActiveUsers(userActions).forEach(System.out::println);
        Methods.findTonFiveTopic(userActions).forEach(System.out::println);
        Methods.findTopThreeUsersByContent(userActions).forEach(System.out::println);
        Methods.findPercentageForAction(userActions).entrySet().forEach(System.out::println);
    }
}
