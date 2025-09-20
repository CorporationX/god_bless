package school.faang.bjs2_88333;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    public static List<UserAction> getSampleUserActions() {
        List<UserAction> actions = new ArrayList<>();

        actions.add(createAction(1, "Alice", ActionType.POST,
                LocalDate.of(2025, 9, 1), "Check out this amazing #newfeature!"));
        actions.add(createAction(2, "Bob", ActionType.COMMENT,
                LocalDate.of(2025, 9, 2), "I totally agree with #newfeature."));
        actions.add(createAction(1, "Alice", ActionType.LIKE,
                LocalDate.of(2025, 9, 3), ""));
        actions.add(createAction(3, "Charlie", ActionType.SHARE,
                LocalDate.of(2025, 9, 4), ""));
        actions.add(createAction(4, "Dave", ActionType.POST,
                LocalDate.of(2025, 9, 5), "#Java is awesome!"));
        actions.add(createAction(2, "Bob", ActionType.LIKE,
                LocalDate.of(2025, 9, 6), ""));
        actions.add(createAction(3, "Charlie", ActionType.POST,
                LocalDate.of(2025, 9, 7), "Check out this cool #project"));
        actions.add(createAction(1, "Alice", ActionType.COMMENT,
                LocalDate.of(2025, 9, 8), "Thanks for sharing #project!"));
        actions.add(createAction(4, "Dave", ActionType.LIKE,
                LocalDate.of(2025, 9, 9), ""));
        actions.add(createAction(2, "Bob", ActionType.COMMENT,
                LocalDate.of(2025, 9, 10), "#Java is everywhere."));
        actions.add(createAction(5, "Eve", ActionType.POST,
                LocalDate.of(2025, 9, 11), "Loving the new #feature release!"));
        actions.add(createAction(3, "Charlie", ActionType.COMMENT,
                LocalDate.of(2025, 9, 12), "#Java is indeed awesome."));
        actions.add(createAction(5, "Eve", ActionType.LIKE,
                LocalDate.of(2025, 9, 13), ""));
        actions.add(createAction(4, "Dave", ActionType.SHARE,
                LocalDate.of(2025, 9, 14), ""));
        actions.add(createAction(2, "Bob", ActionType.POST,
                LocalDate.of(2025, 9, 15), "Introducing a new #update to the system."));
        actions.add(createAction(1, "Alice", ActionType.SHARE,
                LocalDate.of(2025, 9, 16), ""));
        actions.add(createAction(5, "Eve", ActionType.COMMENT,
                LocalDate.of(2025, 9, 17), "#update looks great!"));
        actions.add(createAction(3, "Charlie", ActionType.LIKE,
                LocalDate.of(2025, 9, 18), ""));
        actions.add(createAction(4, "Dave", ActionType.COMMENT,
                LocalDate.of(2025, 9, 19), "Really liking the new #feature."));
        actions.add(createAction(2, "Bob", ActionType.SHARE,
                LocalDate.of(2025, 9, 20), ""));
        actions.add(createAction(1, "Alice", ActionType.POST,
                LocalDate.of(2025, 9, 21), "Excited for the upcoming #conference!"));
        actions.add(createAction(3, "Charlie", ActionType.COMMENT,
                LocalDate.of(2025, 9, 22), "I'll be at the #conference too!"));
        actions.add(createAction(5, "Eve", ActionType.LIKE,
                LocalDate.of(2025, 9, 23), ""));
        actions.add(createAction(4, "Dave", ActionType.POST,
                LocalDate.of(2025, 9, 24), "Had a great time at the #conference."));
        actions.add(createAction(2, "Bob", ActionType.COMMENT,
                LocalDate.of(2025, 9, 25), "#conference was a blast!"));
        actions.add(createAction(1, "Alice", ActionType.LIKE,
                LocalDate.of(2025, 9, 26), ""));
        actions.add(createAction(3, "Charlie", ActionType.SHARE,
                LocalDate.of(2025, 9, 27), ""));

        actions.add(createAction(5, "Eve", ActionType.POST,
                LocalDate.of(2025, 9, 28), "The new #update is rolling out today."));
        actions.add(createAction(4, "Dave", ActionType.LIKE,
                LocalDate.of(2025, 9, 29), ""));
        actions.add(createAction(1, "Alice", ActionType.COMMENT,
                LocalDate.of(2025, 9, 30), "Excited to try out the new #update!"));
        actions.add(createAction(2, "Bob", ActionType.SHARE,
                LocalDate.of(2025, 10, 1), ""));
        actions.add(createAction(3, "Charlie", ActionType.COMMENT,
                LocalDate.of(2025, 10, 2), "The #update has some great features."));
        actions.add(createAction(5, "Eve", ActionType.LIKE,
                LocalDate.of(2025, 10, 3), ""));
        actions.add(createAction(4, "Dave", ActionType.SHARE,
                LocalDate.of(2025, 10, 4), ""));
        actions.add(createAction(1, "Alice", ActionType.POST,
                LocalDate.of(2025, 10, 5), "Loving the new #update so far."));
        actions.add(createAction(2, "Bob", ActionType.LIKE,
                LocalDate.of(2025, 10, 6), ""));
        actions.add(createAction(3, "Charlie", ActionType.POST,
                LocalDate.of(2025, 10, 7), "Here's my review of the new #update."));
        actions.add(createAction(5, "Eve", ActionType.COMMENT,
                LocalDate.of(2025, 10, 8), "Your #review was helpful!"));
        actions.add(createAction(4, "Dave", ActionType.LIKE,
                LocalDate.of(2025, 10, 9), ""));
        actions.add(createAction(1, "Alice", ActionType.SHARE,
                LocalDate.of(2025, 10, 10), ""));
        actions.add(createAction(3, "Charlie", ActionType.COMMENT,
                LocalDate.of(2025, 10, 11), "Sharing my thoughts on the #update."));
        actions.add(createAction(5, "Eve", ActionType.POST,
                LocalDate.of(2025, 10, 12), "What a great #feature this update brings!"));
        actions.add(createAction(2, "Bob", ActionType.LIKE,
                LocalDate.of(2025, 10, 13), ""));
        actions.add(createAction(4, "Dave", ActionType.COMMENT,
                LocalDate.of(2025, 10, 14), "#feature works really well."));
        actions.add(createAction(1, "Alice", ActionType.POST,
                LocalDate.of(2025, 10, 15), "The #feature saved me a lot of time."));
        actions.add(createAction(3, "Charlie", ActionType.LIKE,
                LocalDate.of(2025, 10, 16), ""));
        actions.add(createAction(5, "Eve", ActionType.SHARE,
                LocalDate.of(2025, 10, 17), ""));
        actions.add(createAction(2, "Bob", ActionType.POST,
                LocalDate.of(2025, 10, 18), "Can't wait for the next #update."));
        actions.add(createAction(4, "Dave", ActionType.SHARE,
                LocalDate.of(2025, 10, 19), ""));

        return actions;
    }

    private static UserAction createAction(int userId, String userName,
                                           ActionType actionType, LocalDate actionDate, String content) {
        return new UserAction(userId, userName, actionType, actionDate, content);
    }
}