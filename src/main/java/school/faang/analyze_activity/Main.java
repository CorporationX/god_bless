package school.faang.analyze_activity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 4, 2), "I totally agree with #newfeature."),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 4, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 9, 3), ""),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 4, 10), "#Java is everywhere."),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2024, 9, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 4, 8), "Thanks for sharing #project!"));
        System.out.println(ActivityAnalyzer.topUsersByActions(actions, 2));
        System.out.println(ActivityAnalyzer.topHashTags(actions, 2));
        System.out.println(ActivityAnalyzer.topCommentersLastMonth(actions, 2));
        System.out.println(ActivityAnalyzer.actionTypePercentages(actions));
    }
}
