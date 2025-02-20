package school.faang.activity.analysis;

import java.time.LocalDate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        String[] users = {"Alice", "Bob", "Charlie", "Dave", "Eve"};
        String[] messages = {"Check out this amazing #newfeature!", "I totally agree with #newfeature.", "",
                "Check out this cool #project", "Thanks for sharing #project!", "#Java is awesome!",
                "#update looks great!", "Excited for the upcoming #conference!", "Had a great time at the #conference.",
                "Excited to try out the new #update!", "The #update has some great features.",
                "Your #review was helpful!", "Sharing my thoughts on the #update.",
                "What a great #feature this update brings!", "#feature works really well."
        };

        List<UserAction> actions = IntStream.range(0, 50)
                .mapToObj(i -> {
                    int userId = i % users.length;
                    ActionType actionType = ActionType.values()[i % ActionType.values().length];
                    String message = i < messages.length ? messages[i] : "";
                    LocalDate date = LocalDate.of(2024, 9, 1).plusDays(i);

                    return new UserAction(i + 1, users[userId], actionType, date, message);
                })
                .collect(Collectors.toList());

        List<String> top10Users = UserActionAnalyzer.topActiveUser(actions, 10);
        List<String> top10Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 10);
        List<String> top5Comments = UserActionAnalyzer.topCommentersLastMonth(actions, 5);
        Map<ActionType, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Top 10 active users: " + top10Users);
        System.out.println("Top 10 popular hashtags: " + top10Hashtags);
        System.out.println("Top 5 commentators in the last month: " + top5Comments);
        System.out.println("Percentage of actions by type: " + actionPercentages);
    }
}
