import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import user.collect.User;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    @DisplayName("Testing find hobby method with null list of users")
    void userTest_findHobbyIfUsersIsNull() {
        List<User> users = null;
        Set<String> activities = Set.of("Drawing", "Swimming");

        var result = User.findHobbyLovers(users, activities);

        assertNull(result);
    }

    @Test
    @DisplayName("Testing find hobby method with null list of activities")
    void userTest_findHobbyIfActivitiesIsNull() {
        List<User> users = List.of(
                new User(1, "Alesha", 20, Set.of("Drawing", "Hiking")),
                new User(2, "Vova", 23, Set.of("Fitness", "Gaming"))
        );
        Set<String> activities = null;

        var result = User.findHobbyLovers(users, activities);

        assertNull(result);
    }

    @Test
    @DisplayName("Testing find hobby method with for correct result")
    void userTest_findHobbyCorrectResult() {
        User user1 = new User(1, "Vitya", 24, Set.of("Fitness", "Reading"));
        User user2 = new User(2, "Vika", 21, Set.of("Kayaking", "Drawing"));
        User user3 = new User(3, "Dimas", 30, Set.of("Writing", "Gardening"));
        List<User> users = List.of(user1, user2, user3);
        Set<String> activities = Set.of("Fitness", "Drawing");

        var result = User.findHobbyLovers(users, activities);

        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertTrue(result.containsKey(user1)),
                () -> assertTrue(result.containsKey(user2))
        );
    }
}
