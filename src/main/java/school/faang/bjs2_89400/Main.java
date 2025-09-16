package school.faang.bjs2_89400;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static List<UserAction> actions;

    static {
        actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 8, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE,
                        LocalDate.of(2025, 8, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2025, 8, 4), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2025, 8, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 8, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST,
                        LocalDate.of(2025, 8, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 8, 9), ""),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 8, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 12), "#Java is indeed awesome."),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 8, 13), ""),
                new UserAction(4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 8, 14), ""),
                new UserAction(2, "Bob", ActionType.POST,
                        LocalDate.of(2025, 8, 15),
                        "Introducing a new #update to the system."),
                new UserAction(1, "Alice", ActionType.SHARE,
                        LocalDate.of(2025, 8, 16), ""),
                new UserAction(5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 17), "#update looks great!"),
                new UserAction(3, "Charlie", ActionType.LIKE,
                        LocalDate.of(2025, 8, 18), ""),
                new UserAction(4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", ActionType.SHARE,
                        LocalDate.of(2025, 8, 20), ""),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 8, 21),
                        "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 8, 23), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2025, 8, 24),
                        "Had a great time at the #conference."),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", ActionType.LIKE,
                        LocalDate.of(2025, 8, 26), ""),
                new UserAction(3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2025, 8, 27), ""),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 8, 28),
                        "The new #update is rolling out today."),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 8, 29), ""),
                new UserAction(1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2025, 8, 30), "Excited to try out the new #update!"),
                new UserAction(2, "Bob", ActionType.SHARE,
                        LocalDate.of(2025, 8, 31), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 9, 1), "The #update has some great features."),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 9, 2), ""),
                new UserAction(4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 9, 3), ""),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 9, 4), "Loving the new #update so far."),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 9, 5), ""),
                new UserAction(3, "Charlie", ActionType.POST,
                        LocalDate.of(2025, 9, 6), "Here's my review of the new #update."),
                new UserAction(5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2025, 9, 7), "Your #review was helpful!"),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 9, 8), ""),
                new UserAction(1, "Alice", ActionType.SHARE,
                        LocalDate.of(2025, 9, 9), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 9, 10), "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 9, 11),
                        "What a great #feature this update brings!"),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 9, 12), ""),
                new UserAction(4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2025, 9, 13), "#feature works really well."),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 9, 14),
                        "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", ActionType.LIKE,
                        LocalDate.of(2025, 9, 15), ""),
                new UserAction(5, "Eve", ActionType.SHARE,
                        LocalDate.of(2025, 9, 16), "")
        );
    }

    public static void main(String[] args) {
        UserActionAnalyzer userActionAnalyzer = new UserActionAnalyzer();

        System.out.println("Топ 3 активных юзеров:");
        userActionAnalyzer.getTopActiveUsers(actions, 3).forEach(System.out::println);

        System.out.println("Топ 3 тем для обсуждения:");
        userActionAnalyzer.getTopPopularHashtags(actions, 3).forEach(System.out::println);

        System.out.println("Топ 3 комментаторов:");
        userActionAnalyzer.getTopCommentersLastMonth(actions, 3).forEach(System.out::println);

        System.out.println("Процентное соотношение типов действий:");
        userActionAnalyzer.getActionTypePercentage(actions).forEach((key, value) ->
                System.out.printf("%s -> %.2f%%%n", key, value));
    }
}
