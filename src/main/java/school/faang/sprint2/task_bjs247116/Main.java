package school.faang.sprint2.task_bjs247116;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {

    public static final String POST = "post";
    public static final String COMMENT = "comment";
    public static final String LIKE = "like";
    public static final String SHARE = "share";

    public static void main(String[] args) {
        List<UserAction> actions = getUserActions();

        List<String> topUsers = UserActionAnalyzer.topActiveUsers(actions);
        List<String> topHashtags = UserActionAnalyzer.topPopularHashtags(actions);
        List<String> topCommenters = UserActionAnalyzer.topCommentersLastMonth(actions);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + topUsers);
        System.out.println("Топ-5 популярных хэштегов: " + topHashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + topCommenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }

    private static List<UserAction> getUserActions() {
        return Arrays.asList(
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 11, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 11, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", LIKE, LocalDate.of(2024, 11, 3), ""),
                new UserAction(3, "Charlie", SHARE, LocalDate.of(2024, 11, 4), ""),
                new UserAction(4, "Dave", POST, LocalDate.of(2024, 11, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 11, 6), ""),
                new UserAction(3, "Charlie", POST, LocalDate.of(2024, 11, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", COMMENT, LocalDate.of(2024, 11, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 11, 9), ""),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 11, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", POST, LocalDate.of(2024, 11, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 11, 12), "#Java is indeed awesome."),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 11, 13), ""),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 11, 14), ""),
                new UserAction(2, "Bob", POST,
                        LocalDate.of(2024, 11, 15), "Introducing a new #update to the system."),
                new UserAction(1, "Alice", SHARE, LocalDate.of(2024, 11, 16), ""),
                new UserAction(5, "Eve", COMMENT, LocalDate.of(2024, 11, 17), "#update looks great!"),
                new UserAction(3, "Charlie", LIKE, LocalDate.of(2024, 11, 18), ""),
                new UserAction(4, "Dave", COMMENT, LocalDate.of(2024, 11, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", SHARE, LocalDate.of(2024, 11, 20), ""),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 11, 21), "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 11, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 11, 23), ""),
                new UserAction(4, "Dave", POST, LocalDate.of(2024, 11, 24), "Had a great time at the #conference."),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 11, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", LIKE, LocalDate.of(2024, 11, 26), ""),
                new UserAction(3, "Charlie", SHARE, LocalDate.of(2024, 11, 27), ""),
                new UserAction(5, "Eve", POST, LocalDate.of(2024, 11, 28), "The new #update is rolling out today."),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 11, 29), ""),
                new UserAction(1, "Alice", COMMENT,
                        LocalDate.of(2024, 11, 30), "Excited to try out the new #update!"),
                new UserAction(2, "Bob", SHARE, LocalDate.of(2024, 12, 1), ""),
                new UserAction(3, "Charlie", COMMENT,
                        LocalDate.of(2024, 12, 2), "The #update has some great features."),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 12, 3), ""),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 12, 4), ""),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 12, 5), "Loving the new #update so far."),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 12, 6), ""),
                new UserAction(3, "Charlie", POST, LocalDate.of(2024, 12, 7), "Here's my review of the new #update."),
                new UserAction(5, "Eve", COMMENT, LocalDate.of(2024, 12, 8), "Your #review was helpful!"),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 12, 9), ""),
                new UserAction(1, "Alice", SHARE, LocalDate.of(2024, 12, 10), ""),
                new UserAction(3, "Charlie", COMMENT,
                        LocalDate.of(2024, 12, 11), "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", POST,
                        LocalDate.of(2024, 12, 12), "What a great #feature this update brings!"),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 12, 13), ""),
                new UserAction(4, "Dave", COMMENT, LocalDate.of(2024, 12, 14), "#feature works really well."),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 12, 15), "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", LIKE, LocalDate.of(2024, 12, 16), ""),
                new UserAction(5, "Eve", SHARE, LocalDate.of(2024, 12, 17), ""),
                new UserAction(2, "Bob", POST, LocalDate.of(2024, 12, 18), "Can't wait for the next #update."),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 12, 19), "")
        );
    }
}