package school.faang.task_47258;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {

    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 9, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2024, 9, 4), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2024, 9, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2024, 9, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2024, 9, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2024, 9, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2024, 9, 9), ""),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 9, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2024, 9, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 9, 12), "#Java is indeed awesome."),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2024, 9, 13), ""),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2024, 9, 14), ""),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2024, 9, 15), "Introducing a new #update to the system."),
                new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2024, 9, 16), ""),
                new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2024, 9, 17), "#update looks great!"),
                new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2024, 9, 18), ""),
                new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2024, 9, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2024, 10, 20), ""),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 10, 21), "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 10, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2024, 10, 23), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2024, 10, 24), "Had a great time at the #conference."),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 10, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 10, 26), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2024, 10, 27), ""),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2024, 10, 28), "The new #update is rolling out today."),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2024, 10, 21), ""),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2024, 10, 30), "Excited to try out the new #update!"),
                new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2024, 11, 1), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 11, 24), "The #update has some great features."),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2024, 11, 3), ""),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2024, 11, 4), ""),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 11, 5), "Loving the new #update so far."),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2024, 11, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2024, 11, 7), "Here's my review of the new #update."),
                new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2024, 12, 1), "Your #review was helpful!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2024, 11, 9), ""),
                new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2024, 11, 11), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 11, 11), "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2024, 11, 12), "What a great #feature this update brings!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2024, 11, 13), ""),
                new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2024, 11, 19), "#feature works really well."),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 11, 15), "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2024, 11, 16), ""),
                new UserAction(5, "Eve", ActionType.SHARE, LocalDate.of(2024, 11, 17), ""),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2024, 11, 18), "Can't wait for the next #update."),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2024, 11, 19), ""),
                new UserAction(6, "John", ActionType.COMMENT, LocalDate.of(2024, 12, 11), "")

        );

        System.out.println(UserActionAnalyzer.topActiveUsers(actions));
        System.out.println(UserActionAnalyzer.topPopularHashtags(actions));
        System.out.println(UserActionAnalyzer.topCommentersLastMonth(actions));
        System.out.println(UserActionAnalyzer.actionPercentages(actions));
    }
}
