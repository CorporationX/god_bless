import org.junit.jupiter.api.Test;
import school.faang.collectUsers.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUser {

    @Test
    public void testIfActivitiesAreFoundForUser() {
        // arrange
        User user1 = new User(1, "Sanchez", 20, Set.of("Swimming", "Basketball", "Football", "Video games"));
        User user2 = new User(2, "Oleg", 40, Set.of("Sleeping", "Eating", "Dota 2"));
        List<User> usersList = List.of(user1, user2);
        Set<String> activityList = Set.of("Crypto", "Running", "Basketball", "Video games", "Eating burgers");

        Map<User, String> expected = new HashMap<>();

        // act
        expected.put(user1, "Basketball");
        Map<User, String> actual = User.findHobbyLovers(usersList, activityList);

        // assert
        assertEquals(expected, actual, "Must return a map with a key user1 and only a value of Basketball");
    }
}
