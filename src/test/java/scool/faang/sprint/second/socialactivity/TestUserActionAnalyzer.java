package scool.faang.sprint.second.socialactivity;

import org.junit.Assert;
import org.junit.Test;
import school.faang.sprint.second.socialactivity.ActionType;
import school.faang.sprint.second.socialactivity.UserAction;
import school.faang.sprint.second.socialactivity.UserActionAnalyzer;
import school.faang.sprint.second.socialactivity.UsernameBlankException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestUserActionAnalyzer {
    private final List<UserAction> actions = Arrays.asList(
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 9, 1), "Check out this amazing #newfeature!"),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 9, 2), "I totally agree with #newfeature."),
            new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 9, 3), ""),
            new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 9, 4), ""),
            new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 9, 5), "#Java is awesome!"),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 9, 6), ""),
            new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 9, 7), "Check out this cool #project"),
            new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 9, 8), "Thanks for sharing #project!"),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 9, 9), ""),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 9, 10), "#Java is everywhere."),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 9, 11), "Loving the new #feature release!"),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 9, 12), "#Java is indeed awesome."),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 9, 13), ""),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 9, 14), ""),
            new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2025, 9, 15), "Introducing a new #update to the system."),
            new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2025, 9, 16), ""),
            new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2025, 9, 17), "#update looks great!"),
            new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2025, 9, 18), ""),
            new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 9, 19), "Really liking the new #feature."),
            new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2025, 9, 20), ""),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 9, 21), "Excited for the upcoming #conference!"),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 9, 22), "I'll be at the #conference too!"),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 9, 23), ""),
            new UserAction(4, "Dave", ActionType.POST, LocalDate.of(2025, 9, 24), "Had a great time at the #conference."),
            new UserAction(2, "Bob", ActionType.COMMENT, LocalDate.of(2025, 9, 25), "#conference was a blast!"),
            new UserAction(1, "Alice", ActionType.LIKE, LocalDate.of(2025, 9, 26), ""),
            new UserAction(3, "Charlie", ActionType.SHARE, LocalDate.of(2025, 9, 27), ""),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 9, 28), "The new #update is rolling out today."),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 9, 29), ""),
            new UserAction(1, "Alice", ActionType.COMMENT, LocalDate.of(2025, 9, 30), "Excited to try out the new #update!"),
            new UserAction(2, "Bob", ActionType.SHARE, LocalDate.of(2025, 10, 1), ""),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 10, 2), "The #update has some great features."),
            new UserAction(5, "Eve", ActionType.LIKE, LocalDate.of(2025, 10, 3), ""),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 10, 4), ""),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 10, 5), "Loving the new #update so far."),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 10, 6), ""),
            new UserAction(3, "Charlie", ActionType.POST, LocalDate.of(2025, 10, 7), "Here's my review of the new #update."),
            new UserAction(5, "Eve", ActionType.COMMENT, LocalDate.of(2025, 10, 8), "Your #review was helpful!"),
            new UserAction(4, "Dave", ActionType.LIKE, LocalDate.of(2025, 10, 9), ""),
            new UserAction(1, "Alice", ActionType.SHARE, LocalDate.of(2025, 10, 10), ""),
            new UserAction(3, "Charlie", ActionType.COMMENT, LocalDate.of(2025, 10, 11), "Sharing my thoughts on the #update."),
            new UserAction(5, "Eve", ActionType.POST, LocalDate.of(2025, 10, 12), "What a great #feature this update brings!"),
            new UserAction(2, "Bob", ActionType.LIKE, LocalDate.of(2025, 10, 13), ""),
            new UserAction(4, "Dave", ActionType.COMMENT, LocalDate.of(2025, 10, 14), "#feature works really well."),
            new UserAction(1, "Alice", ActionType.POST, LocalDate.of(2025, 10, 15), "The #feature saved me a lot of time."),
            new UserAction(3, "Charlie", ActionType.LIKE, LocalDate.of(2025, 10, 16), ""),
            new UserAction(5, "Eve", ActionType.SHARE, LocalDate.of(2025, 10, 17), ""),
            new UserAction(2, "Bob", ActionType.POST, LocalDate.of(2025, 10, 18), "Can't wait for the next #update."),
            new UserAction(4, "Dave", ActionType.SHARE, LocalDate.of(2025, 10, 19), "")
    );

    @Test
    public void testTopActiveUsers() {
        String exceptedTop10Users = "[Alice, Bob, Charlie, Dave, Eve]";
        List<String> actualTop10Users = UserActionAnalyzer.topActiveUsers(actions, 10);

        Assert.assertEquals(exceptedTop10Users, actualTop10Users.toString());
    }

    @Test
    public void testTopPopularHashtags() {
        String exceptedTop5Hashtags = "[#update, #feature, #conference, #Java, #newfeature]";
        List<String> actualTop5Hashtags = UserActionAnalyzer.topPopularHashtags(actions, 5);

        Assert.assertEquals(exceptedTop5Hashtags, actualTop5Hashtags.toString());
    }

    @Test
    public void testTopCommentersLastMonth() {
        String exceptedTop3Commenters = "[Alice, Charlie, Bob]";
        List<String> top3Commenters = UserActionAnalyzer.topCommentersLastMonth(actions, 3);

        Assert.assertEquals(exceptedTop3Commenters, top3Commenters.toString());
    }

    @Test
    public void testActionTypePercentages() {
        String exceptedActionPercentages = "{LIKE=26.53, POST=26.53, SHARE=20.41, COMMENT=26.53}";
        Map<String, Double> actualActionPercentages = UserActionAnalyzer.actionTypePercentages(actions);

        Assert.assertEquals(exceptedActionPercentages, actualActionPercentages.toString());
    }

    @Test(expected = UsernameBlankException.class)
    public void testUsernameBlank() {
        new UserAction(1, "", ActionType.COMMENT, LocalDate.now(), "");
    }
}
