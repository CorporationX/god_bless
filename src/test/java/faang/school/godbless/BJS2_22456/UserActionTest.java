package faang.school.godbless.BJS2_22456;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static faang.school.godbless.BJS2_22456.ActionType.*;

class UserActionTest {

    List<UserAction> userActions = new ArrayList<>();

    {

        // User 1: Alice
        userActions.add(new UserAction(1, "Alice", POST, LocalDateTime.of(2023, 10, 26, 10, 30, 0), "This is my #car first post!"));
        userActions.add(new UserAction(1, "Alice", POST, LocalDateTime.of(2023, 10, 26, 10, 30, 0), "This is my first post!"));
        userActions.add(new UserAction(1, "Alice", POST, LocalDateTime.of(2023, 10, 26, 10, 30, 0), "This is my first post!"));
        userActions.add(new UserAction(1, "Alice", COMMENT, LocalDateTime.of(2024, 8, 1, 11, 15, 0), "Great post!"));
        userActions.add(new UserAction(1, "Alice", SHARE, LocalDateTime.of(2023, 10, 27, 14, 0, 0), "Shared this with #car my friends!"));
        userActions.add(new UserAction(1, "Alice", SHARE, LocalDateTime.of(2023, 10, 27, 14, 0, 0), "Shared this #house with my friends!"));

        // User 2: Bob
        userActions.add(new UserAction(2, "Bob", POST, LocalDateTime.of(2023, 10, 25, 16, 45, 0), "Check out #car this amazing article!"));
        userActions.add(new UserAction(2, "Bob", POST, LocalDateTime.of(2023, 10, 25, 16, 45, 0), "Check out this amazing #work article!"));
        userActions.add(new UserAction(2, "Bob", POST, LocalDateTime.of(2023, 10, 25, 16, 45, 0), "Check out #work this amazing article!"));
        userActions.add(new UserAction(2, "Bob", POST, LocalDateTime.of(2023, 10, 25, 16, 45, 0), "Check out this amazing #house article!"));
        userActions.add(new UserAction(2, "Bob", LIKE, LocalDateTime.of(2023, 10, 26, 10, 35, 0), "👍"));
        userActions.add(new UserAction(2, "Bob", LIKE, LocalDateTime.of(2023, 10, 26, 10, 35, 0), "👍"));
        userActions.add(new UserAction(2, "Bob", LIKE, LocalDateTime.of(2023, 10, 26, 10, 35, 0), "👍"));
        userActions.add(new UserAction(2, "Bob", COMMENT, LocalDateTime.of(2024, 8, 10, 17, 20, 0), "I agree #house with you."));
        userActions.add(new UserAction(2, "Bob", COMMENT, LocalDateTime.of(2024, 7, 20, 17, 20, 0), "I agree with you."));

        // User 3: Charlie
        userActions.add(new UserAction(3, "Charlie", POST, LocalDateTime.of(2023, 10, 24, 12, 10, 0), "What are your #car thoughts on this?"));
        userActions.add(new UserAction(3, "Charlie", POST, LocalDateTime.of(2023, 10, 24, 12, 10, 0), "What are #house your thoughts on this?"));
        userActions.add(new UserAction(3, "Charlie", COMMENT, LocalDateTime.of(2024, 8, 10, 9, 45, 0), "Interesting #car perspective."));
        userActions.add(new UserAction(3, "Charlie", COMMENT, LocalDateTime.of(2024, 8, 10, 9, 45, 0), "Interesting #house perspective."));
        userActions.add(new UserAction(3, "Charlie", COMMENT, LocalDateTime.of(2024, 8, 10, 9, 45, 0), "Interesting #car perspective."));
        userActions.add(new UserAction(3, "Charlie", LIKE, LocalDateTime.of(2023, 10, 25, 11, 0, 0), "❤️"));
        userActions.add(new UserAction(3, "Charlie", LIKE, LocalDateTime.of(2023, 10, 25, 11, 1, 0), "❤️"));
        userActions.add(new UserAction(3, "Charlie", LIKE, LocalDateTime.of(2023, 10, 25, 11, 2, 0), "❤️"));
        userActions.add(new UserAction(3, "Charlie", LIKE, LocalDateTime.of(2023, 10, 25, 11, 3, 0), "❤️"));
        userActions.add(new UserAction(3, "Charlie", LIKE, LocalDateTime.of(2023, 10, 25, 11, 4, 0), "❤️"));
        userActions.add(new UserAction(3, "Charlie", LIKE, LocalDateTime.of(2023, 10, 25, 11, 5, 0), "❤️"));

        // User 4: David
        userActions.add(new UserAction(4, "David", POST, LocalDateTime.of(2023, 10, 27, 19, 55, 0), "This is my new post!"));
        userActions.add(new UserAction(4, "David", POST, LocalDateTime.of(2023, 10, 27, 19, 58, 0), "This is my #car new post2!"));
        userActions.add(new UserAction(4, "David", COMMENT, LocalDateTime.of(2024, 7, 28, 10, 10, 0), "Great #work post!"));
        userActions.add(new UserAction(4, "David", COMMENT, LocalDateTime.of(2024, 7, 28, 10, 10, 0), "Great post!"));
        userActions.add(new UserAction(4, "David", COMMENT, LocalDateTime.of(2024, 7, 28, 10, 10, 0), "Great post!"));
        userActions.add(new UserAction(4, "David", COMMENT, LocalDateTime.of(2024, 7, 28, 10, 10, 0), "Great #house post!"));
        userActions.add(new UserAction(4, "David", COMMENT, LocalDateTime.of(2024, 7, 28, 10, 10, 0), "Great post!"));
        userActions.add(new UserAction(4, "David", COMMENT, LocalDateTime.of(2024, 7, 28, 10, 10, 0), "Great post!"));
        userActions.add(new UserAction(4, "David", SHARE, LocalDateTime.of(2023, 10, 28, 14, 30, 0), "Reposting this to my feed."));

        // User 5: Eve
        userActions.add(new UserAction(5, "Eve", POST, LocalDateTime.of(2023, 10, 26, 21, 30, 0), "Check out this #house amazing article!"));
        userActions.add(new UserAction(5, "Eve", POST, LocalDateTime.of(2023, 10, 26, 21, 30, 0), "Check out this #work amazing article!"));
        userActions.add(new UserAction(5, "Eve", LIKE, LocalDateTime.of(2023, 10, 27, 10, 20, 0), "🔥"));
        userActions.add(new UserAction(5, "Eve", LIKE, LocalDateTime.of(2023, 10, 27, 10, 20, 0), "🔥"));
        userActions.add(new UserAction(5, "Eve", LIKE, LocalDateTime.of(2023, 10, 27, 10, 20, 0), "🔥"));
        userActions.add(new UserAction(5, "Eve", COMMENT, LocalDateTime.of(2024, 7, 27, 16, 50, 0), "I agree with you."));
        userActions.add(new UserAction(5, "Eve", COMMENT, LocalDateTime.of(2024, 7, 27, 16, 50, 0), "I agree with #work you."));
        userActions.add(new UserAction(5, "Eve", COMMENT, LocalDateTime.of(2024, 7, 27, 16, 50, 0), "I agree with #car you."));
        userActions.add(new UserAction(5, "Eve", COMMENT, LocalDateTime.of(2024, 7, 27, 16, 50, 0), "I agree with #house you."));
        userActions.add(new UserAction(5, "Eve", COMMENT, LocalDateTime.of(2024, 7, 27, 16, 50, 0), "I agree with #car you."));
        userActions.add(new UserAction(5, "Eve", COMMENT, LocalDateTime.of(2024, 7, 27, 16, 50, 0), "I agree with #work you."));
        userActions.add(new UserAction(5, "Eve", COMMENT, LocalDateTime.of(2024, 7, 27, 16, 50, 0), "I agree with you."));
        userActions.add(new UserAction(5, "Eve", COMMENT, LocalDateTime.of(2024, 7, 27, 16, 50, 0), "I agree with you."));

        // User 6: Frank
        userActions.add(new UserAction(6, "Frank", POST, LocalDateTime.of(2023, 10, 25, 18, 15, 0), "What are your #it thoughts on this?"));
        userActions.add(new UserAction(6, "Frank", COMMENT, LocalDateTime.of(2023, 10, 26, 8, 50, 0), "Interesting #it perspective."));

        userActions.add(new UserAction(6, "Frank", LIKE, LocalDateTime.of(2023, 10, 26, 12, 10, 0), "❤️"));

        // User 7: Grace
        userActions.add(new UserAction(7, "Grace", POST, LocalDateTime.of(2023, 10, 28, 11, 0, 0), "This is my #tv new post!"));
        userActions.add(new UserAction(7, "Grace", POST, LocalDateTime.of(2023, 10, 28, 11, 0, 0), "This is #tv my new post!"));
        userActions.add(new UserAction(7, "Grace", POST, LocalDateTime.of(2023, 10, 28, 11, 0, 0), "This is my #tv new post!"));
        userActions.add(new UserAction(7, "Grace", POST, LocalDateTime.of(2023, 10, 28, 11, 0, 0), "This is my #tv new post!"));
        userActions.add(new UserAction(7, "Grace", COMMENT, LocalDateTime.of(2024, 8, 15, 15, 15, 0), "Great #tv post!"));
        userActions.add(new UserAction(7, "Grace", COMMENT, LocalDateTime.of(2024, 8, 15, 15, 15, 0), "Great #tv post!"));
        userActions.add(new UserAction(7, "Grace", COMMENT, LocalDateTime.of(2024, 8, 15, 15, 15, 0), "Great #tv post!"));
        userActions.add(new UserAction(7, "Grace", COMMENT, LocalDateTime.of(2024, 8, 15, 15, 15, 0), "Great #tv post!"));
        userActions.add(new UserAction(7, "Grace", SHARE, LocalDateTime.of(2023, 10, 29, 10, 0, 0), "Shared this #tv with my friends!"));
        userActions.add(new UserAction(7, "Grace", SHARE, LocalDateTime.of(2023, 10, 29, 10, 0, 0), "Shared this with my friends!"));
        userActions.add(new UserAction(7, "Grace", SHARE, LocalDateTime.of(2023, 10, 29, 10, 0, 0), "Shared this #car with my friends!"));
        userActions.add(new UserAction(7, "Grace", SHARE, LocalDateTime.of(2023, 10, 29, 10, 0, 0), "Shared this #house with my friends!"));
        userActions.add(new UserAction(7, "Grace", SHARE, LocalDateTime.of(2023, 10, 29, 10, 0, 0), "Shared this #food with my friends!"));
        userActions.add(new UserAction(7, "Grace", SHARE, LocalDateTime.of(2023, 10, 29, 10, 0, 0), "Shared this with #food my friends!"));

        // User 8: Henry
        userActions.add(new UserAction(8, "Henry", POST, LocalDateTime.of(2023, 10, 27, 17, 30, 0), "Check out #food this amazing article!"));
        userActions.add(new UserAction(8, "Henry", POST, LocalDateTime.of(2023, 10, 27, 17, 30, 0), "Check out this #food amazing article!"));
        userActions.add(new UserAction(8, "Henry", LIKE, LocalDateTime.of(2023, 10, 28, 9, 45, 0), "👍"));
        userActions.add(new UserAction(8, "Henry", COMMENT, LocalDateTime.of(2023, 10, 28, 13, 30, 0), "I agree with #food you."));
        userActions.add(new UserAction(8, "Henry", COMMENT, LocalDateTime.of(2023, 10, 28, 13, 30, 0), "I agree with #notebook you."));
        userActions.add(new UserAction(8, "Henry", COMMENT, LocalDateTime.of(2023, 10, 28, 13, 30, 0), "I agree with you."));
        userActions.add(new UserAction(8, "Henry", COMMENT, LocalDateTime.of(2023, 10, 28, 13, 30, 0), "I agree with #notebook you."));

        // User 9: Iris
        userActions.add(new UserAction(9, "Iris", POST, LocalDateTime.of(2023, 10, 25, 20, 0, 0), "What are your thoughts #notebook on this?"));
        userActions.add(new UserAction(9, "Iris", POST, LocalDateTime.of(2023, 10, 25, 20, 0, 0), "What are your #notebook thoughts on this?"));
        userActions.add(new UserAction(9, "Iris", POST, LocalDateTime.of(2023, 10, 25, 20, 0, 0), "What are your #notebook thoughts on this?"));
        userActions.add(new UserAction(9, "Iris", POST, LocalDateTime.of(2023, 10, 25, 20, 0, 0), "What are your #notebook thoughts on this?"));
        userActions.add(new UserAction(9, "Iris", POST, LocalDateTime.of(2023, 10, 25, 20, 0, 0), "What are your thoughts on this?"));
        userActions.add(new UserAction(9, "Iris", POST, LocalDateTime.of(2023, 10, 25, 20, 0, 0), "What are your thoughts on this?"));
        userActions.add(new UserAction(9, "Iris", POST, LocalDateTime.of(2023, 10, 25, 20, 0, 0), "What are your thoughts #notebook on this?"));
        userActions.add(new UserAction(9, "Iris", COMMENT, LocalDateTime.of(2023, 10, 26, 11, 50, 0), "Interesting #notebook perspective."));
        userActions.add(new UserAction(9, "Iris", COMMENT, LocalDateTime.of(2023, 10, 26, 11, 50, 0), "Interesting perspective."));
        userActions.add(new UserAction(9, "Iris", LIKE, LocalDateTime.of(2023, 10, 26, 17, 0, 0), "❤️"));
        userActions.add(new UserAction(9, "Iris", LIKE, LocalDateTime.of(2023, 10, 26, 17, 0, 0), "❤️"));
        userActions.add(new UserAction(9, "Iris", LIKE, LocalDateTime.of(2023, 10, 26, 17, 0, 0), "❤️"));
        userActions.add(new UserAction(9, "Iris", LIKE, LocalDateTime.of(2023, 10, 26, 17, 0, 0), "❤️"));
        userActions.add(new UserAction(9, "Iris", LIKE, LocalDateTime.of(2023, 10, 26, 17, 0, 0), "❤️"));
        userActions.add(new UserAction(9, "Iris", LIKE, LocalDateTime.of(2023, 10, 26, 17, 0, 0), "❤️"));

        // User 10: Jack
        userActions.add(new UserAction(10, "Jack", POST, LocalDateTime.of(2023, 10, 28, 8, 30, 0), "This is my #meta new post!"));
        userActions.add(new UserAction(10, "Jack", POST, LocalDateTime.of(2023, 10, 28, 8, 30, 0), "This is my new post!"));
        userActions.add(new UserAction(10, "Jack", COMMENT, LocalDateTime.of(2023, 10, 28, 12, 45, 0), "Great #meta post!"));
        userActions.add(new UserAction(10, "Jack", COMMENT, LocalDateTime.of(2023, 10, 28, 12, 45, 0), "Great #meta post!"));
        userActions.add(new UserAction(10, "Jack", SHARE, LocalDateTime.of(2023, 10, 29, 16, 30, 0), "Reposting this #meta to my feed."));
        userActions.add(new UserAction(10, "Jack", SHARE, LocalDateTime.of(2023, 10, 29, 16, 30, 0), "Reposting this #meta to my feed."));
        userActions.add(new UserAction(10, "Jack", SHARE, LocalDateTime.of(2023, 10, 29, 16, 30, 0), "Reposting this #meta to my feed."));
        userActions.add(new UserAction(10, "Jack", SHARE, LocalDateTime.of(2023, 10, 29, 16, 30, 0), "Reposting this to my feed."));
        userActions.add(new UserAction(10, "Jack", SHARE, LocalDateTime.of(2023, 10, 29, 16, 30, 0), "Reposting this to my feed."));

    }

    @Test
    void findTop10UsersTest() {
        Social.findTop10Users(userActions).forEach((a, b) -> System.out.println(a + ": " + b));
    }

    @Test
    void findTop5ThemesTest() {
        Social.findTop5Themes(userActions).forEach((k, v) -> System.out.println(k + ": " + v));
    }

    @Test
    void lastMonthTop3UsersMadeCommentsTest() {
        Social.lastMonthTop3UsersMadeComments(userActions).forEach((k, v) -> System.out.println(k + ": " + v));
    }

    @Test
    void percentOfActions() {
        Social.percentOfActions(userActions).forEach((k, v) -> System.out.println(k + ": " + v));
    }

}