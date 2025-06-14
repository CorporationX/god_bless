package school.faang.socials;

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author Danil Pudovkin
 * @since 13.06.2025
 */
public class Main {

    public static final String ALICE = "Alice";
    public static final String CHARLIE = "Charlie";
    public static final String BOB = "Bob";
    public static final String DAVE = "Dave";
    public static final String EVE = "Eve";

    public static void main(String[] args) {
        var actions = Arrays.asList(
                new UserAction(1, ALICE, ActionType.POST, LocalDate.of(2025, 9, 1),
                        "Check out this amazing #newfeature!"),
                new UserAction(2, BOB, ActionType.COMMENT, LocalDate.of(2025, 9, 2),
                        "I totally agree with #newfeature."),
                new UserAction(1, ALICE, ActionType.LIKE, LocalDate.of(2025, 9, 3), ""),
                new UserAction(3, CHARLIE, ActionType.SHARE, LocalDate.of(2025, 9, 4), ""),
                new UserAction(4, DAVE, ActionType.POST, LocalDate.of(2025, 9, 5), "#Java is awesome!"),
                new UserAction(2, BOB, ActionType.LIKE, LocalDate.of(2025, 9, 6), ""),
                new UserAction(3, CHARLIE, ActionType.POST, LocalDate.of(2025, 9, 7),
                        "Check out this cool #project"),
                new UserAction(1, ALICE, ActionType.COMMENT, LocalDate.of(2025, 9, 8),
                        "Thanks for sharing #project!"),
                new UserAction(4, DAVE, ActionType.LIKE, LocalDate.of(2025, 9, 9), ""),
                new UserAction(2, BOB, ActionType.COMMENT, LocalDate.of(2025, 9, 10), "#Java is everywhere."),
                new UserAction(5, EVE, ActionType.POST, LocalDate.of(2025, 9, 11),
                        "Loving the new #feature release!"),
                new UserAction(3, CHARLIE, ActionType.COMMENT, LocalDate.of(2025, 9, 12), "#Java is indeed awesome."),
                new UserAction(5, EVE, ActionType.LIKE, LocalDate.of(2025, 9, 13), ""),
                new UserAction(4, DAVE, ActionType.SHARE, LocalDate.of(2025, 9, 14), ""),
                new UserAction(2, BOB, ActionType.POST, LocalDate.of(2025, 9, 15),
                        "Introducing a new #update to the system."),
                new UserAction(1, ALICE, ActionType.SHARE, LocalDate.of(2025, 9, 16), ""),
                new UserAction(5, EVE, ActionType.COMMENT, LocalDate.of(2025, 9, 17), "#update looks great!"),
                new UserAction(3, CHARLIE, ActionType.LIKE, LocalDate.of(2025, 9, 18), ""),
                new UserAction(4, DAVE, ActionType.COMMENT, LocalDate.of(2025, 9, 19),
                        "Really liking the new #feature."),
                new UserAction(2, BOB, ActionType.SHARE, LocalDate.of(2025, 9, 20), ""),
                new UserAction(1, ALICE, ActionType.POST, LocalDate.of(2025, 9, 21),
                        "Excited for the upcoming #conference!"),
                new UserAction(3, CHARLIE, ActionType.COMMENT, LocalDate.of(2025, 9, 22),
                        "I'll be at the #conference too!"),
                new UserAction(5, EVE, ActionType.LIKE, LocalDate.of(2025, 9, 23), ""),
                new UserAction(4, DAVE, ActionType.POST, LocalDate.of(2025, 9, 24),
                        "Had a great time at the #conference."),
                new UserAction(2, BOB, ActionType.COMMENT, LocalDate.of(2025, 9, 25), "#conference was a blast!"),
                new UserAction(1, ALICE, ActionType.LIKE, LocalDate.of(2025, 9, 26), ""),
                new UserAction(3, CHARLIE, ActionType.SHARE, LocalDate.of(2025, 9, 27), ""),
                new UserAction(5, EVE, ActionType.POST, LocalDate.of(2025, 9, 28),
                        "The new #update is rolling out today."),
                new UserAction(4, DAVE, ActionType.LIKE, LocalDate.of(2025, 9, 29), ""),
                new UserAction(1, ALICE, ActionType.COMMENT, LocalDate.of(2025, 9, 30),
                        "Excited to try out the new #update!"),
                new UserAction(2, BOB, ActionType.SHARE, LocalDate.of(2025, 10, 1), ""),
                new UserAction(3, CHARLIE, ActionType.COMMENT, LocalDate.of(2025, 10, 2),
                        "The #update has some great features."),
                new UserAction(5, EVE, ActionType.LIKE, LocalDate.of(2025, 10, 3), ""),
                new UserAction(4, DAVE, ActionType.SHARE, LocalDate.of(2025, 10, 4), ""),
                new UserAction(1, ALICE, ActionType.POST, LocalDate.of(2025, 10, 5),
                        "Loving the new #update so far."),
                new UserAction(2, BOB, ActionType.LIKE, LocalDate.of(2025, 10, 6), ""),
                new UserAction(3, CHARLIE, ActionType.POST, LocalDate.of(2025, 10, 7),
                        "Here's my review of the new #update."),
                new UserAction(5, EVE, ActionType.COMMENT, LocalDate.of(2025, 10, 8), "Your #review was helpful!"),
                new UserAction(4, DAVE, ActionType.LIKE, LocalDate.of(2025, 10, 9), ""),
                new UserAction(1, ALICE, ActionType.SHARE, LocalDate.of(2025, 10, 10), ""),
                new UserAction(3, CHARLIE, ActionType.COMMENT, LocalDate.of(2025, 10, 11),
                        "Sharing my thoughts on the #update."),
                new UserAction(5, EVE, ActionType.POST, LocalDate.of(2025, 10, 12),
                        "What a great #feature this update brings!"),
                new UserAction(2, BOB, ActionType.LIKE, LocalDate.of(2025, 10, 13), ""),
                new UserAction(4, DAVE, ActionType.COMMENT, LocalDate.of(2025, 10, 14),
                        "#feature works really well."),
                new UserAction(1, ALICE, ActionType.POST, LocalDate.of(2025, 10, 15),
                        "The #feature saved me a lot of time."),
                new UserAction(3, CHARLIE, ActionType.LIKE, LocalDate.of(2025, 10, 16), ""),
                new UserAction(5, EVE, ActionType.SHARE, LocalDate.of(2025, 10, 17), ""),
                new UserAction(2, BOB, ActionType.POST, LocalDate.of(2025, 10, 18),
                        "Can't wait for the next #update."),
                new UserAction(4, DAVE, ActionType.SHARE, LocalDate.of(2025, 10, 19), "")
        );

        // Получение результатов
        var top10Users = UserActionAnalyzer.topActiveUsers(actions, 10);
        var top5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);
        var top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);
        var actionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        // Вывод результатов
        System.out.println("Топ-10 активных пользователей: " + top10Users);
        System.out.println("Топ-5 популярных хэштегов: " + top5Hashtags);
        System.out.println("Топ-3 комментаторов за последний месяц: " + top3Commenters);
        System.out.println("Процент действий по типам: " + actionPercentages);
    }
}
