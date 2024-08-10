package faang.school.godbless.UserCollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    List<User> users;

    @BeforeEach
    void setUp()
    {
        users = new ArrayList<>();
    }

    @Test
    void testGetHobbyLovers()
    {
        User danya = new User("danya", 12, "pushkina-kolotushkina", "a", Set.of("dota", "lol"));
        User alex = new User("alex", 12, "pushkina-kolotushkina", "a", Set.of("cs"));

        users.add(new User("valera", 12, "pushkina-kolotushkina", "a", Set.of("gta", "dota")));
        users.add(new User("danya", 12, "pushkina-kolotushkina", "a", Set.of("dota", "lol")));
        users.add(new User("alex", 12, "pushkina-kolotushkina", "a", Set.of("cs")));
        users.add(new User("arkadiy", 12, "pushkina-kolotushkina", "a", Set.of("gym")));

        Map<User, String> activitiesLovers = User.getHobbyLovers(users, Set.of("dota", "cs"));

        assertTrue(activitiesLovers.containsKey(danya));
        assertTrue(activitiesLovers.containsKey(alex));
    }
}