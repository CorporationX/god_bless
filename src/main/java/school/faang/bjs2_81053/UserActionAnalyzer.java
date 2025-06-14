package school.faang.bjs2_81053;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class UserActionAnalyzer {
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
                new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2024, 9, 20), ""),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 9, 21), "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 9, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2024, 9, 23), ""),
                new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2024, 9, 24), "Had a great time at the #conference."),
                new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2024, 9, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2024, 9, 26), ""),
                new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2024, 9, 27), ""),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2024, 9, 28), "The new #update is rolling out today."),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2024, 9, 29), ""),
                new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2024, 9, 30), "Excited to try out the new #update!"),
                new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2024, 10, 1), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 10, 2), "The #update has some great features."),
                new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2024, 10, 3), ""),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2024, 10, 4), ""),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 10, 5), "Loving the new #update so far."),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2024, 10, 6), ""),
                new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2024, 10, 7), "Here's my review of the new #update."),
                new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2024, 10, 8), "Your #review was helpful!"),
                new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2024, 10, 9), ""),
                new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2024, 10, 10), ""),
                new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2024, 10, 11), "Sharing my thoughts on the #update."),
                new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2024, 10, 12), "What a great #feature this update brings!"),
                new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2024, 10, 13), ""),
                new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2024, 10, 14), "#feature works really well."),
                new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2024, 10, 15), "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2024, 10, 16), ""),
                new UserAction(5, "Eve", ActionType.SHARE, LocalDate.of(2024, 10, 17), ""),
                new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2024, 10, 18), "Can't wait for the next #update."),
                new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2024, 10, 19), "")
        );

        List<String> top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        List<String> top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        Map<String, Double> actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }

    public static List<String> topActiveUsers(List<UserAction> actions, int n) {
        return actions.stream()
                .collect(Collectors.groupingBy(a -> a.name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topPopularHashtags(List<UserAction> actions, int n) {
        Pattern hashtagPattern = Pattern.compile("#\\w+");

        return actions.stream()
                .filter(a -> a.actionType == ActionType.POST || a.actionType == ActionType.COMMENT)
                .flatMap(a -> {
                    Matcher matcher = hashtagPattern.matcher(a.content);
                    List<String> hashtags = new ArrayList<>();
                    while (matcher.find()) {
                        hashtags.add(matcher.group().toLowerCase());
                    }
                    return hashtags.stream();
                })
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static List<String> topCommentersLastMonth(List<UserAction> actions, int n) {
        LocalDate now = LocalDate.now();
        LocalDate monthAgo = now.minus(1, ChronoUnit.MONTHS);

        return actions.stream()
                .filter(a -> a.actionType == ActionType.COMMENT)
                .filter(a -> !a.actionDate.isBefore(monthAgo) && !a.actionDate.isAfter(now))
                .collect(Collectors.groupingBy(a -> a.name, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }

    public static Map<String, Double> actionTypePercentages(List<UserAction> actions) {
        long total = actions.size();

        Map<ActionType, Long> counts = actions.stream()
                .collect(Collectors.groupingBy(a -> a.actionType, Collectors.counting()));

        Map<String, Double> percentages = new LinkedHashMap<>();

        for (ActionType type : ActionType.values()) {
            long count = counts.getOrDefault(type, 0L);
            double percent = total == 0 ? 0.0 : (count * 100.0) / total;
            percentages.put(type.name(), percent);
        }

        return percentages;
    }
}
