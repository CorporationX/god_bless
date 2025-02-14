package school.faang.analyzeactivity;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    private static final List<UserAction> ACTIONS = createAndFillingList();
    private static final int COUNT_USERS = 3;
    private static final int COUNT_HASHTAGS = 4;
    private static final int COUNT_COMMENTERS = 3;

    public static void main(String[] args) {
        try {
            List<String> top3Users = UserActionAnalyzer.topActiveUsers(ACTIONS, COUNT_USERS);
            List<String> top4Hashtags = UserActionAnalyzer.topPopularHashtags(ACTIONS, COUNT_HASHTAGS);
            List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(ACTIONS, COUNT_COMMENTERS);
            Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(ACTIONS, ACTIONS.size());

            log.info("Top 3 users on activity: {}", printPretty(top3Users));
            log.info("Top 4 popular hashtags: {}", printPretty(top4Hashtags));
            log.info("Top 3 commenters on the last month: {}", printPretty(top3Commenters));
            log.info("% actions on even type: {}", printPretty(actionPercentages));
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }

    private static List<UserAction> createAndFillingList() {
        return List.of(
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 1, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", ActionType.LIKE,
                        LocalDate.of(2025, 1, 3), ""),
                new UserAction(3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2025, 1, 4), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2025, 1, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 1, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST,
                        LocalDate.of(2025, 1, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 1, 9), ""),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 1, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 11), "#Java is indeed awesome."),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 1, 11), ""),
                new UserAction(4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 1, 11), ""),
                new UserAction(2, "Bob", ActionType.POST,
                        LocalDate.of(2025, 1, 11),
                        "Introducing a new #update to the system."),
                new UserAction(1, "Alice", ActionType.SHARE,
                        LocalDate.of(2025, 1, 11), ""),
                new UserAction(3, "Charlie", ActionType.LIKE,
                        LocalDate.of(2025, 1, 11), ""),
                new UserAction(5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 18), "#update looks great!"),
                new UserAction(4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", ActionType.SHARE,
                        LocalDate.of(2025, 1, 20), ""),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 1, 21),
                        "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 1, 23), ""),
                new UserAction(4, "Dave", ActionType.POST,
                        LocalDate.of(2025, 1, 24),
                        "Had a great time at the #conference."),
                new UserAction(2, "Bob", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", ActionType.LIKE,
                        LocalDate.of(2025, 1, 26), ""),
                new UserAction(3, "Charlie", ActionType.SHARE,
                        LocalDate.of(2025, 1, 27), ""),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 1, 28),
                        "The new #update is rolling out today."),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 1, 29), ""),
                new UserAction(1, "Alice", ActionType.COMMENT,
                        LocalDate.of(2025, 1, 30),
                        "Excited to try out the new #update!"),
                new UserAction(2, "Bob", ActionType.SHARE,
                        LocalDate.of(2025, 2, 1), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 2),
                        "The #update has some great features."),
                new UserAction(5, "Eve", ActionType.LIKE,
                        LocalDate.of(2025, 2, 3), ""),
                new UserAction(4, "Dave", ActionType.SHARE,
                        LocalDate.of(2025, 2, 4), ""),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 2, 5), "Loving the new #update so far."),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 2, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST,
                        LocalDate.of(2025, 2, 7),
                        "Here's my review of the new #update."),
                new UserAction(5, "Eve", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 8), "Your #review was helpful!"),
                new UserAction(4, "Dave", ActionType.LIKE,
                        LocalDate.of(2025, 2, 9), ""),
                new UserAction(1, "Alice", ActionType.SHARE,
                        LocalDate.of(2025, 2, 10), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 11),
                        "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", ActionType.POST,
                        LocalDate.of(2025, 2, 12),
                        "What a great #feature this update brings!"),
                new UserAction(2, "Bob", ActionType.LIKE,
                        LocalDate.of(2025, 2, 12), ""),
                new UserAction(4, "Dave", ActionType.COMMENT,
                        LocalDate.of(2025, 2, 12), "#feature works really well."),
                new UserAction(1, "Alice", ActionType.POST,
                        LocalDate.of(2025, 2, 12),
                        "The #feature saved me a lot of time."),
                new UserAction(5, "Eve", ActionType.SHARE,
                        LocalDate.of(2025, 2, 12), ""),
                new UserAction(2, "Bob", ActionType.POST,
                        LocalDate.of(2025, 2, 12), "Can't wait for the next #update."),
                new UserAction(5, "Eve", ActionType.SHARE,
                        LocalDate.of(2025, 2, 12), ""),
                new UserAction(5, "Eve", ActionType.SHARE,
                        LocalDate.of(2025, 2, 12), "")
        );
    }

    private static String printPretty(List<String> list) {
        return String.join(" ", list);
    }

    private static String printPretty(Map<String, Double> map) {
        Objects.requireNonNull(map);
        return map.entrySet().stream()
                .map(entry -> entry.getKey() + ": " +
                        transformDouble(entry.getValue())).collect(Collectors.joining(" "));

    }

    private static double transformDouble(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
