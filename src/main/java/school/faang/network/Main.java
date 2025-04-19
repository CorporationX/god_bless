package school.faang.network;


import com.fasterxml.jackson.databind.introspect.Annotated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserAction> list = List.of(
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 3, 1),
                        "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 3, 2),
                        "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 3, 3),
                        ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2024, 3, 4),
                        ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2024, 3, 5),
                        "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2024, 3, 6),
                        ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2024, 3, 7),
                        "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2024, 3, 8),
                        "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2024, 3, 9),
                        ""),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 3, 10),
                        "#Java is everywhere."),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2024, 3, 11),
                        "Loving the new #feature release!"),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 3, 12),
                        "#Java is indeed awesome."),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2024, 3, 13),
                        ""),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2024, 3, 14),
                        ""));

        UserActionAnalyzer analyzer = new UserActionAnalyzer();
        //System.out.println(analyzer.userActivity(list, 3));
        //System.out.println(analyzer.popularTopicDiscussion(list, '#', 2));
        System.out.println(analyzer.maxComment(list, 3));
    }

}
