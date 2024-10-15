package school.faang.user.activitiy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    List<UserAction> actions = Arrays.asList(
        new UserAction(1, "Alice", "post", LocalDate.of(2024, 9, 1),
            "Check out this amazing #newfeature!"),
        new UserAction(2, "Bob", "comment", LocalDate.of(2024, 9, 2),
            "#Java #Java #Java I totally agree with #newfeature."),
        new UserAction(1, "Alice", "like", LocalDate.of(2024, 9, 3), ""),
        new UserAction(3, "Charlie", "share", LocalDate.of(2024, 9, 4), ""),
        new UserAction(4, "Dave", "post", LocalDate.of(2024, 9, 5), "#Java is awesome!"),
        new UserAction(2, "Bob", "like", LocalDate.of(2024, 9, 6), ""),
        new UserAction(3, "Charlie", "post", LocalDate.of(2024, 9, 7),
            "Check out this cool #project"),
        new UserAction(1, "Alice", "comment", LocalDate.of(2024, 9, 8),
            "Thanks for sharing #project!"),
        new UserAction(4, "Dave", "like", LocalDate.of(2024, 9, 9), ""),
        new UserAction(2, "Bob", "comment", LocalDate.of(2024, 9, 10), "#Java is everywhere."),
        new UserAction(5, "Eve", "post", LocalDate.of(2024, 9, 11),
            "Loving the new #feature release!"),
        new UserAction(3, "Charlie", "comment", LocalDate.of(2024, 9, 12),
            "#Java is indeed awesome."),
        new UserAction(5, "Eve", "like", LocalDate.of(2024, 9, 13), ""),
        new UserAction(4, "Dave", "share", LocalDate.of(2024, 9, 14), ""),
        new UserAction(2, "Bob", "post", LocalDate.of(2024, 9, 15),
            "Introducing a new #update to the system."),
        new UserAction(1, "Alice", "share", LocalDate.of(2024, 9, 16), ""),
        new UserAction(5, "Eve", "comment", LocalDate.of(2024, 9, 17), "#update looks great!"),
        new UserAction(3, "Charlie", "like", LocalDate.of(2024, 9, 18), ""),
        new UserAction(4, "Dave", "comment", LocalDate.of(2024, 9, 19),
            "Really liking the new #feature."),
        new UserAction(2, "Bob", "share", LocalDate.of(2024, 9, 20), ""),
        new UserAction(1, "Alice", "post", LocalDate.of(2024, 9, 21),
            "Excited for the upcoming #conference!"),
        new UserAction(3, "Charlie", "comment", LocalDate.of(2024, 9, 22),
            "I'll be at the #conference too!"),
        new UserAction(5, "Eve", "like", LocalDate.of(2024, 9, 23), ""),
        new UserAction(4, "Dave", "post", LocalDate.of(2024, 9, 24),
            "Had a great time at the #conference."),
        new UserAction(2, "Bob", "comment", LocalDate.of(2024, 9, 25), "#conference was a blast!"),
        new UserAction(1, "Alice", "like", LocalDate.of(2024, 9, 26), ""),
        new UserAction(3, "Charlie", "share", LocalDate.of(2024, 9, 27), ""),
        new UserAction(5, "Eve", "post", LocalDate.of(2024, 9, 28),
            "The new #update is rolling out today."),
        new UserAction(4, "Dave", "like", LocalDate.of(2024, 9, 29), ""),
        new UserAction(1, "Alice", "comment", LocalDate.of(2024, 9, 30),
            "Excited to try out the new #update!"),
        new UserAction(2, "Bob", "share", LocalDate.of(2024, 10, 1), ""),
        new UserAction(3, "Charlie", "comment", LocalDate.of(2024, 10, 2),
            "The #update has some great features."),
        new UserAction(5, "Eve", "like", LocalDate.of(2024, 10, 3), ""),
        new UserAction(4, "Dave", "share", LocalDate.of(2024, 10, 4), ""),
        new UserAction(1, "Alice", "post", LocalDate.of(2024, 10, 5),
            "Loving the new #update so far."),
        new UserAction(2, "Bob", "like", LocalDate.of(2024, 10, 6), ""),
        new UserAction(3, "Charlie", "post", LocalDate.of(2024, 10, 7),
            "Here's my review of the new #update."),
        new UserAction(5, "Eve", "comment", LocalDate.of(2024, 10, 8), "Your #review was helpful!"),
        new UserAction(4, "Dave", "like", LocalDate.of(2024, 10, 9), ""),
        new UserAction(1, "Alice", "share", LocalDate.of(2024, 10, 10), ""),
        new UserAction(3, "Charlie", "comment", LocalDate.of(2024, 10, 11),
            "Sharing my thoughts on the #update."),
        new UserAction(5, "Eve", "post", LocalDate.of(2024, 10, 12),
            "What a great #feature this update brings!"),
        new UserAction(2, "Bob", "like", LocalDate.of(2024, 10, 13), ""),
        new UserAction(4, "Dave", "comment", LocalDate.of(2024, 10, 14),
            "#feature works really well."),
        new UserAction(1, "Alice", "post", LocalDate.of(2024, 10, 15),
            "The #feature saved me a lot of time."),
        new UserAction(3, "Charlie", "like", LocalDate.of(2024, 10, 16), ""),
        new UserAction(5, "Eve", "share", LocalDate.of(2024, 10, 17), ""),
        new UserAction(2, "Bob", "post", LocalDate.of(2024, 10, 18),
            "Can't wait for the next #update."),
        new UserAction(4, "Dave", "share", LocalDate.of(2024, 10, 19), "")
    );

    System.out.println("Top 10 users:");
    UserActionAnalyzer.topActiveUsers(actions).forEach(System.out::println);

    System.out.println("Top 5 hashtags:");
    UserActionAnalyzer.topHashTags(actions).forEach(System.out::println);

    System.out.println("Top 3 commenters:");
    UserActionAnalyzer.topCommenters(actions).forEach(System.out::println);

    System.out.println("Actions percentage by type:");
    System.out.println(UserActionAnalyzer.actionPercentage(actions));
  }

  public static class UserActionAnalyzer {

    public static Map<String, Double> actionPercentage(List<UserAction> actions) {
      int totalActions = actions.size();
      return actions.stream()
          .collect(Collectors.groupingBy(UserAction::actionType, Collectors.counting()))
          .entrySet()
          .stream()
          .collect(Collectors.toMap(
              Entry::getKey, stringLongEntry -> stringLongEntry.getValue() * 100.0 / totalActions));
    }

    public static List<String> topCommenters(List<UserAction> actions) {
      int top = 3;
      LocalDate oneMonthAgo = LocalDate.now().minusMonths(1);
      var map = actions.stream()
          .filter(userAction -> userAction.actionType().equals("comment") && userAction.actionDate()
              .isAfter(oneMonthAgo))
          .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
      return getTopGroups(map, top);
    }

    public static List<String> topHashTags(List<UserAction> actions) {
      int top = 5;
      var map = actions.stream()
          .filter(userAction -> userAction.actionType().equals("post") || userAction.actionType()
              .equals("comment"))
          .map(action -> extractHashTag(action.content()))
          .flatMap(Collection::stream)
          .collect(Collectors.groupingBy(string -> string, Collectors.counting()));
      return getTopGroups(map, top);
    }

    public static List<String> topActiveUsers(List<UserAction> actions) {
      int top = 10;
      var map = actions.stream()
          .collect(Collectors.groupingBy(UserAction::name, Collectors.counting()));
      return getTopGroups(map, top);
    }

    public static List<String> getTopGroups(Map<String, Long> map, int top) {
      return map.entrySet()
          .stream()
          .filter(entry -> !entry.getKey().isEmpty())
          .sorted((entry1, entry2) -> Math.toIntExact(entry2.getValue() - entry1.getValue()))
          .limit(top)
          .map(streamListEntry -> streamListEntry.getValue() + " : "
              + streamListEntry.getKey())
          .toList();
    }

    public static List<String> extractHashTag(String str) {
      String regex = "#(\\w+)";
      List<String> hashtags = new ArrayList<>();
      Pattern myPattern = Pattern.compile(regex);
      Matcher mat = myPattern.matcher(str);
      while (mat.find()) {
        hashtags.add(mat.group(0));
      }
      return hashtags;
    }
  }
}
