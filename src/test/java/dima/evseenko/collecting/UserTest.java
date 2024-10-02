package dima.evseenko.collecting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void groupUsersFullList() {
        Map<User, String> hobbyLovers = User.findHobbyLovers(getUsers(), Set.of("Games", "Guitar"));

        assertTrue(hobbyLovers.containsKey(new User(1L, "Dima", 22, Set.of("Guitar", "Football"))));
        assertTrue(hobbyLovers.containsKey(new User(5L, "Polina", 19, Set.of("Games", "Football"))));
    }

    @Test
    void groupUsersEmptyList() {
        Map<User, String> hobbyLovers = User.findHobbyLovers(getUsers(), Set.of());

        assertTrue(hobbyLovers.isEmpty());
    }

    @Test
    void groupUsersNullList() {
        assertThrows(IllegalArgumentException.class, () -> User.findHobbyLovers(null, Set.of("Guitar", "Football")));
    }

    @Test
    void groupActivitiesNullSet() {
        assertThrows(IllegalArgumentException.class, () -> User.findHobbyLovers(getUsers(), null));
    }

    private List<User> getUsers() {
        return Arrays.asList(
                new User(1L, "Dima", 22, Set.of("Guitar", "Football")),
                new User(2L, "Vasya", 21, Set.of("Swimming", "Basketball")),
                new User(3L, "Kolya", 20, Set.of("Running", "Flying")),
                new User(4L, "Sasha", 24, Set.of("Programming", "Football")),
                new User(5L, "Polina", 19, Set.of("Games", "Football"))
        );
    }
}