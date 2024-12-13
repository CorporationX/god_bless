package school.faang.sprint2.task_47174;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static school.faang.sprint2.task_47174.ActionType.POST;
import static school.faang.sprint2.task_47174.ActionType.COMMENT;
import static school.faang.sprint2.task_47174.ActionType.LIKE;
import static school.faang.sprint2.task_47174.ActionType.SHARE;

public class Main {
    public static void main(String[] args) {
        List<UserAction> actions = Arrays.asList(
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 9, 1), "Check out this amazing #newfeature!"),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 9, 2), "I totally agree with #newfeature."),
                new UserAction(1, "Alice", LIKE, LocalDate.of(2024, 11, 3), "#conference"),
                new UserAction(3, "Charlie", SHARE, LocalDate.of(2024, 9, 4), "#bootcamp has a lot of features"),
                new UserAction(4, "Dave", POST, LocalDate.of(2024, 9, 5), "#Java is awesome!"),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 9, 6), "#pp who wants?"),
                new UserAction(3, "Charlie", POST, LocalDate.of(2024, 9, 7), "Check out this cool #project"),
                new UserAction(1, "Alice", COMMENT, LocalDate.of(2024, 9, 8), "Thanks for sharing #project!"),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 9, 9), "#bootcamp java is the best"),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 9, 10), "#Java is everywhere."),
                new UserAction(5, "Eve", POST, LocalDate.of(2024, 11, 11), "Loving the new #feature release!"),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 11, 12), "#Java is indeed awesome."),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 11, 13), "Sharing my thoughts on the #update"),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 11, 14), "#javajourney"),
                new UserAction(2, "Bob", POST, LocalDate.of(2024, 11, 15), "Introducing new #update to the system."),
                new UserAction(1, "Alice", SHARE, LocalDate.of(2024, 11, 16), "The new #update is rolling today."),
                new UserAction(5, "Eve", COMMENT, LocalDate.of(2024, 11, 17), "#update looks great!"),
                new UserAction(3, "Charlie", LIKE, LocalDate.of(2024, 11, 18), "Had great time at the #conference."),
                new UserAction(4, "Dave", COMMENT, LocalDate.of(2024, 11, 19), "Really liking the new #feature."),
                new UserAction(2, "Bob", SHARE, LocalDate.of(2024, 11, 20), "Loving the new #feature release!"),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 9, 21), "Excited for the upcoming #conference!"),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 9, 22), "I'll be at the #conference too!"),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 9, 23), "#feature works really well."),
                new UserAction(4, "Dave", POST, LocalDate.of(2024, 9, 24), "Had a great time at the #conference."),
                new UserAction(2, "Bob", COMMENT, LocalDate.of(2024, 9, 25), "#conference was a blast!"),
                new UserAction(1, "Alice", LIKE, LocalDate.of(2024, 9, 26), "Can't wait for the next #update"),
                new UserAction(3, "Charlie", SHARE, LocalDate.of(2024, 9, 27), "The #feature saved me lot of time."),
                new UserAction(5, "Eve", POST, LocalDate.of(2024, 9, 28), "The new #update is rolling out today."),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 11, 29), "Your #review was helpful!"),
                new UserAction(1, "Alice", COMMENT, LocalDate.of(2024, 9, 30), "Excited to try out the new #update"),
                new UserAction(2, "Bob", SHARE, LocalDate.of(2024, 10, 1), ""),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 10, 2), "#update has some great features."),
                new UserAction(5, "Eve", LIKE, LocalDate.of(2024, 10, 3), ""),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 10, 4), ""),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 10, 5), "Loving the new #update so far."),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 10, 6), ""),
                new UserAction(3, "Charlie", POST, LocalDate.of(2024, 10, 7), "Here's my review of the new #update"),
                new UserAction(5, "Eve", COMMENT, LocalDate.of(2024, 11, 8), "Your #review was helpful!"),
                new UserAction(4, "Dave", LIKE, LocalDate.of(2024, 10, 9), ""),
                new UserAction(1, "Alice", SHARE, LocalDate.of(2024, 10, 10), ""),
                new UserAction(3, "Charlie", COMMENT, LocalDate.of(2024, 10, 11), "Sharing thoughts on the #update."),
                new UserAction(5, "Eve", POST, LocalDate.of(2024, 10, 12), "What great #feature this update brings!"),
                new UserAction(2, "Bob", LIKE, LocalDate.of(2024, 10, 13), ""),
                new UserAction(4, "Dave", COMMENT, LocalDate.of(2024, 10, 14), "#feature works really well."),
                new UserAction(1, "Alice", POST, LocalDate.of(2024, 10, 15), "The #feature saved me a lot of time."),
                new UserAction(3, "Charlie", LIKE, LocalDate.of(2024, 11, 16), ""),
                new UserAction(5, "Eve", SHARE, LocalDate.of(2024, 10, 17), ""),
                new UserAction(2, "Bob", POST, LocalDate.of(2024, 10, 18), "Can't wait for the next #update"),
                new UserAction(4, "Dave", SHARE, LocalDate.of(2024, 11, 19), ""),
                new UserAction(6, "Fiona", POST, LocalDate.of(2024, 9, 21), "Exploring the latest #framework!"),
                new UserAction(7, "Grace", COMMENT, LocalDate.of(2024, 9, 22), "I think #framework has potential."),
                new UserAction(8, "Hank", LIKE, LocalDate.of(2024, 9, 23), ""),
                new UserAction(9, "Ivy", SHARE, LocalDate.of(2024, 9, 24), ""),
                new UserAction(10, "Jack", POST, LocalDate.of(2024, 11, 25), "The power of #AI is immense!"),
                new UserAction(11, "Kim", COMMENT, LocalDate.of(2024, 9, 26), "Great insights on #AI!"),
                new UserAction(6, "Fiona", LIKE, LocalDate.of(2024, 9, 27), ""),
                new UserAction(7, "Grace", SHARE, LocalDate.of(2024, 9, 28), ""),
                new UserAction(8, "Hank", POST, LocalDate.of(2024, 9, 29), "Developing with the new #tools."),
                new UserAction(9, "Ivy", COMMENT, LocalDate.of(2024, 9, 30), "#tools are very helpful."),
                new UserAction(10, "Jack", LIKE, LocalDate.of(2024, 10, 1), ""),
                new UserAction(11, "Kim", SHARE, LocalDate.of(2024, 10, 2), ""),
                new UserAction(6, "Fiona", POST, LocalDate.of(2024, 10, 3), "#innovation drives progress!"),
                new UserAction(7, "Grace", COMMENT, LocalDate.of(2024, 10, 4), "#innovation is exciting."),
                new UserAction(8, "Hank", LIKE, LocalDate.of(2024, 10, 5), ""),
                new UserAction(9, "Ivy", SHARE, LocalDate.of(2024, 10, 6), ""),
                new UserAction(10, "Jack", POST, LocalDate.of(2024, 10, 7), "Experimenting with #tech."),
                new UserAction(11, "Kim", COMMENT, LocalDate.of(2024, 10, 8), "#tech advancements are fascinating."),
                new UserAction(6, "Fiona", LIKE, LocalDate.of(2024, 10, 9), ""),
                new UserAction(7, "Grace", SHARE, LocalDate.of(2024, 10, 10), ""),
                new UserAction(8, "Hank", POST, LocalDate.of(2024, 10, 11), "Reviewing the #latest in tech."),
                new UserAction(9, "Ivy", COMMENT, LocalDate.of(2024, 10, 12), "#latest features are impressive."),
                new UserAction(10, "Jack", LIKE, LocalDate.of(2024, 11, 13), ""),
                new UserAction(11, "Kim", SHARE, LocalDate.of(2024, 11, 14), ""),
                new UserAction(6, "Fiona", POST, LocalDate.of(2024, 11, 15), "Exploring more #possibilities."),
                new UserAction(7, "Grace", COMMENT, LocalDate.of(2024, 11, 16), "#possibilities are endless!"),
                new UserAction(8, "Hank", LIKE, LocalDate.of(2024, 10, 17), ""),
                new UserAction(9, "Ivy", SHARE, LocalDate.of(2024, 11, 18), ""),
                new UserAction(10, "Jack", POST, LocalDate.of(2024, 11, 19), "Discovering new #ideas."),
                new UserAction(11, "Kim", COMMENT, LocalDate.of(2024, 10, 20), "Great #ideas coming through."),
                new UserAction(6, "Fiona", LIKE, LocalDate.of(2024, 10, 21), ""),
                new UserAction(7, "Grace", SHARE, LocalDate.of(2024, 11, 22), ""),
                new UserAction(8, "Hank", POST, LocalDate.of(2024, 10, 23), "Focusing on #growth and development."),
                new UserAction(9, "Ivy", COMMENT, LocalDate.of(2024, 10, 24), "#growth is key to success."),
                new UserAction(10, "Jack", LIKE, LocalDate.of(2024, 11, 25), ""),
                new UserAction(11, "Kim", SHARE, LocalDate.of(2024, 10, 26), "")
        );

        UserActionAnalyzer userActionAnalyzer = new UserActionAnalyzer();

        List<String> topUsers = userActionAnalyzer.topActiveUsers(actions);
        List<String> topHashtags = userActionAnalyzer.topPopularHashtags(actions);
        List<String> topCommenters = userActionAnalyzer.topCommentersLastMonth(actions);
        Map<ActionType, Double> actionPercentages = userActionAnalyzer.actionTypePercentages(actions);

        System.out.println("Топ-10 активных пользователей: " + topUsers);
        System.out.println("Топ-5 популярных хэштегов: " + topHashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + topCommenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
