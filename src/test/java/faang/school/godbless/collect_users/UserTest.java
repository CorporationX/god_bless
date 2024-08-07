package faang.school.godbless.collect_users;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testFindHobbyLovers() {
        List<User> userList = List.of(
                new User(1, "Nikita", 25, Set.of("Basketball", "Swimming", "Series", "English", "Music")),
                new User(2, "Nathan", 23, Set.of("Biology", "Series", "Politics", "German", "Music")),
                new User(3, "Matthew", 26, Set.of("History", "Finance", "English", "Music", "Art"))
        );

        // Exception
        assertThrows(IllegalArgumentException.class, () -> User.findHobbyLovers(null, null));
        assertThrows(IllegalArgumentException.class, () -> User.findHobbyLovers(List.of(), Set.of()));

        // Boundary
        assertEquals(0, User.findHobbyLovers(userList, Set.of("Mathematics")).entrySet().size());

        // Positive
        assertEquals(1, User.findHobbyLovers(userList, Set.of("Swimming")).entrySet().size());
        assertEquals(2, User.findHobbyLovers(userList, Set.of("Series")).entrySet().size());
        assertEquals(2, User.findHobbyLovers(userList, Set.of("English")).entrySet().size());
        assertEquals(3, User.findHobbyLovers(userList, Set.of("Basketball", "German", "Art")).entrySet().size());
    }
}
