package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserTest {
    private List<User> users;
    @BeforeEach
    public void setUp() {
        users = getUsers();
    }

    @Test
    public void testFindHobbyLoversWithMatches() {
        Set<String> activities = getActivitiesWithMatches();

        Map<User, String> usersMap = User.findHobbyLovers(users, activities);

        Assertions.assertEquals("Reading", usersMap.get(users.get(0)));
        Assertions.assertEquals("Watching serials", usersMap.get(users.get(1)));
        Assertions.assertEquals("Playing computer games", usersMap.get(users.get(2)));
        Assertions.assertEquals(3, usersMap.size());
    }

    @Test
    public void testFindHobbyLoversWithNoMatches() {
        Set<String> activities = getActivitiesWithNoMatches();

        Map<User, String> usersMap = User.findHobbyLovers(users, activities);

        Assertions.assertEquals(0, usersMap.size());
    }

    private Set<String> getActivitiesWithMatches() {
        return Set.of(
                "Reading", "Watching serials", "Playing computer games"
        );
    }

    private Set<String> getActivitiesWithNoMatches() {
        return Set.of(
                "Writing texts", "Learning Java", "Learning SQL"
        );
    }

    private List<User> getUsers() {
        User user1 = new User(1, "Andrey", 22,
                Set.of("Programming", "Gym", "Reading", "Playing games"));
        User user2 = new User(2, "Denis", 22,
                Set.of("Gym", "Reading books", "Watching serials"));
        User user3 = new User(3, "Vlad", 22,
                Set.of("Reading books", "Watching anime", "Playing computer games"));
        return List.of(user1, user2, user3);
    }
}
