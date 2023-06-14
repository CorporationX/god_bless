package collector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserTest {
    private final User mockUser = new User(0, "F", 1);
    @Test
    public void shouldReturnUsersWithSimilarActivities() {
        List<User> users = getUsers();
        Map<User, String> coincidences = mockUser.findHobbyLovers(users, Set.of("Sport", "Games"));

        Assertions.assertEquals("Sport", coincidences.get(users.get(1)));
        Assertions.assertEquals("Games", coincidences.get(users.get(2)));
        Assertions.assertEquals("Sport", coincidences.get(users.get(3)));
    }

    @Test
    public void shouldNotPutUsersWithDifferentActivities() {
        List<User> users = getUsers();
        Map<User, String> coincidences = mockUser.findHobbyLovers(users, Set.of("Sport", "Games"));

        Assertions.assertNotEquals("Sport", coincidences.get(users.get(0)));
        Assertions.assertNotEquals("Games", coincidences.get(users.get(0)));
        Assertions.assertNotEquals("Sport", coincidences.get(users.get(4)));
        Assertions.assertNotEquals("Games", coincidences.get(users.get(4)));
    }

    private List<User> getUsers() {
        return List.of(
                new User(1100, "Oleg", 40, Set.of("Music", "Alcohol")),
                new User(1115, "Maksim", 40, Set.of("Lego", "Sport")),
                new User(2301, "Mark", 40, Set.of("Music", "Games")),
                new User(7030, "Alex", 40, Set.of("Sport", "Bikes")),
                new User(5055, "Klara", 40, Set.of("Shopping", "Singing"))
        );
    }
}
