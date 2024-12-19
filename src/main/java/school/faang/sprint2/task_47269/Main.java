package school.faang.sprint2.task_47269;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", "post", LocalDate.of(2024, 11, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 11, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", "like", LocalDate.of(2024, 11, 3), ""),
                new UserAction(3, "Charlie", "share", LocalDate.of(2024, 11, 4), ""),
                new UserAction(4, "Dave", "post", LocalDate.of(2024, 11, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", "like", LocalDate.of(2024, 11, 6), ""),
                new UserAction(3, "Charlie", "post", LocalDate.of(2024, 11, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", "comment", LocalDate.of(2024, 11, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", "like", LocalDate.of(2024, 11, 9), ""),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 11, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", "post", LocalDate.of(2024, 11, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", "comment", LocalDate.of(2024, 11, 12), "#Java is indeed awesome."),
                new UserAction(5, "Eve", "like", LocalDate.of(2024, 11, 13), ""),
                new UserAction(4, "Dave", "share", LocalDate.of(2024, 11, 14), ""),
                new UserAction(2, "Bob", "post",
                        LocalDate.of(2024, 9, 15), "Introducing a new #update to the system."),
                new UserAction(1, "Alice", "share", LocalDate.of(2024, 11, 16), ""),
                new UserAction(5, "Eve", "comment", LocalDate.of(2024, 11, 17), null),
                new UserAction(3, "Charlie", "like", LocalDate.of(2024, 11, 18), ""),
                new UserAction(4, "Dave", "comment", LocalDate.of(2024, 11, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", "share", LocalDate.of(2024, 11, 20), ""),
                new UserAction(1, "Alice", "post",
                        LocalDate.of(2024, 11, 21), "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", "comment", LocalDate.of(2024, 11, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", "like", LocalDate.of(2024, 11, 23), ""),
                new UserAction(4, "Dave", "post", LocalDate.of(2024, 11, 24), "Had a great time at the #conference."),
                new UserAction(2, "Bob", "comment", LocalDate.of(2024, 11, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", "like", LocalDate.of(2024, 11, 26), ""),
                new UserAction(3, "Charlie", "share", LocalDate.of(2024, 11, 27), ""),
                new UserAction(5, "Eve", "post", LocalDate.of(2024, 11, 28), "The new #update is rolling out today."),
                new UserAction(4, "Dave", "like", LocalDate.of(2024, 11, 29), ""),
                new UserAction(1, "Alice", "comment",
                        LocalDate.of(2024, 9, 30), "Excited to try out the new #update!"),
                new UserAction(2, "Bob", "share", LocalDate.of(2024, 12, 1), ""),
                new UserAction(3, "Charlie", "comment",
                        LocalDate.of(2024, 10, 2), "The #update has some great features."),
                new UserAction(5, "Eve", "like", LocalDate.of(2024, 12, 3), ""),
                new UserAction(4, "Dave", "share", LocalDate.of(2024, 12, 4), ""),
                new UserAction(1, "Alice", "post", LocalDate.of(2024, 12, 5), "Loving the new #update so far."),
                new UserAction(2, "Bob", "like", LocalDate.of(2024, 12, 6), ""),
                new UserAction(3, "Charlie", "post",
                        LocalDate.of(2024, 10, 7), "Here's my review of the new #update."),
                new UserAction(5, "Eve", "comment", LocalDate.of(2024, 12, 8), "Your #review was helpful!"),
                new UserAction(4, "Dave", "like", LocalDate.of(2024, 12, 9), ""),
                new UserAction(1, "Alice", "share", LocalDate.of(2024, 12, 10), ""),
                new UserAction(3, "Charlie", "comment",
                        LocalDate.of(2024, 12, 11), "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", "post",
                        LocalDate.of(2024, 12, 12), "What a great #feature this update brings!"),
                new UserAction(2, "Bob", "like", LocalDate.of(2024, 12, 13), ""),
                new UserAction(4, "Dave", "comment", LocalDate.of(2024, 12, 14), "#feature works really well."),
                new UserAction(1, "Alice", "post", LocalDate.of(2024, 12, 15), "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", "like", LocalDate.of(2024, 12, 16), ""),
                new UserAction(5, "Eve", "share", LocalDate.of(2024, 12, 17), ""),
                new UserAction(2, "Bob", "post", LocalDate.of(2024, 12, 18), "Can't wait for the next #update.")
        );

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(() -> {
            List<String> topUsers = UserActionAnalyzer.topActiveUsers(actions);
            System.out.println("Топ-10 активных пользователей: " + topUsers);
        });

        executor.submit(() -> {
            List<String> topHashtags = UserActionAnalyzer.topPopularHashtags(actions);
            System.out.println("Топ-5 популярных хэштегов: " + topHashtags);
        });

        executor.submit(() -> {
            List<String> topCommenters = UserActionAnalyzer.topCommentersLastMonth(actions);
            System.out.println("Топ-3 комментаторов за последний месяц: " + topCommenters);
        });

        executor.submit(() -> {
            Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);
            System.out.println("Процент действий поdтипам: " + actionPercentages);
        });

        executor.shutdown();
    }
}
