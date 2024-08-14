package faang.school.godbless.secondsprint.socialnetwork;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        DecimalFormat TWO_DECIMALS = new DecimalFormat("#.00");
        List<UserAction> actions = Arrays.asList(
                new UserAction(1L, "Alice", "post", LocalDateTime.now(), "#FAANG ddk #Java"),
                new UserAction(1L, "Alice", "like", LocalDateTime.now(), "#FAANG ddk #Java"),
                new UserAction(1L, "Alice", "post", LocalDateTime.now(), "#FAANG ddk #Java"),
                new UserAction(2L, "Bob", "comment", LocalDateTime.now().minusDays(4), "#nada ddk #Java"),
                new UserAction(2L, "Bob", "share", LocalDateTime.now(), "#Bootcamp ddk #Java"),
                new UserAction(3L, "Charlie", "share", LocalDateTime.now().minusDays(6), "#nada"),
                new UserAction(3L, "Charlie", "comment", LocalDateTime.now().minusDays(5), "#nada #Java"),
                new UserAction(3L, "Charlie", "comment", LocalDateTime.now().minusDays(6), "nada #Java"),
                new UserAction(4L, "David", "like", LocalDateTime.now(), "#Bootcamp #Equals"),
                new UserAction(4L, "David", "post", LocalDateTime.now(), "#Bootcamp"),
                new UserAction(4L, "David", "comment", LocalDateTime.now().minusDays(45), "#nada"),
                new UserAction(5L, "Eve", "comment", LocalDateTime.now(), "#Bootcamp ddk #Java asd #Coding"),
                new UserAction(5L, "Eve", "comment", LocalDateTime.now().minusDays(12), "nada #Java #Coding"),
                new UserAction(5L, "Eve", "like", LocalDateTime.now(), "#Bootcamp #Java"),
                new UserAction(5L, "Eve", "comment", LocalDateTime.now(), "#Bootcamp #Equals #Coding"),
                new UserAction(6L, "Frank", "like", LocalDateTime.now(), "#Bootcamp #Coding"),
                new UserAction(6L, "Frank", "post", LocalDateTime.now(), "#Bootcamp #FAANG #Coding"),
                new UserAction(7L, "John", "share", LocalDateTime.now(), "#Equals #FAANG #Coding"),
                new UserAction(7L, "John", "comment", LocalDateTime.now().minusDays(24), "#nada ddk #Java #Coding"),
                new UserAction(7L, "John", "share", LocalDateTime.now(), "nada #Equals"),
                new UserAction(7L, "John", "post", LocalDateTime.now(), "nada"),
                new UserAction(7L, "John", "post", LocalDateTime.now(), "nada #Equals "),
                new UserAction(7L, "John", "post", LocalDateTime.now(), "nada #urgent"),
                new UserAction(8L, "El", "comment", LocalDateTime.now().minusDays(4), "nada"),
                new UserAction(9L, "Mike", "comment", LocalDateTime.now().minusDays(7), "#FAANG"),
                new UserAction(9L, "Mike", "comment", LocalDateTime.now().minusDays(37), "#FAANG"),
                new UserAction(9L, "Mike", "comment", LocalDateTime.now().minusDays(72), "#FAANG"),
                new UserAction(10L, "Buddy", "comment", LocalDateTime.now().minusDays(72), "#FAANG"),
                new UserAction(10L, "Buddy", "comment", LocalDateTime.now().minusDays(72), "#FAANG"),
                new UserAction(11L, "Storm", "comment", LocalDateTime.now().minusDays(72), "#FAANG"),
                new UserAction(11L, "Storm", "comment", LocalDateTime.now().minusDays(72), "#FAANG"),
                new UserAction(9L, "Mike", "comment", LocalDateTime.now().minusDays(7), "#google")
        );

        List<String> users = UserActionAnalyzer.getTopTenActiveUsers(actions);
        System.out.println("Top 10 users are: ");
        users.stream().forEach(System.out::println);

        List<String> hashtags = UserActionAnalyzer.getTopHashtags(actions);
        System.out.println("\nTop 5 topics are: ");
        hashtags.stream().forEach(System.out::println);

        List<String> topCommenters = UserActionAnalyzer.getTopCommentersLastMonth(actions);
        System.out.println("\nTop 3 commenters over the last month are: ");
        topCommenters.stream().forEach(System.out::println);

        Map<String, Double> percentage = UserActionAnalyzer.getActionTypePercentages(actions);
        System.out.println("\nPercentages of the actions are: ");
        percentage.forEach((k, v) -> System.out.println(k + ": " + TWO_DECIMALS.format(v) + "%"));
    }
}
