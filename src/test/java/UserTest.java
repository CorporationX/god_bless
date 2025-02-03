import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.faang.usercollection.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private List<User> users;
    private Set<String> hobbies;

    @BeforeEach
    public void setUp() {
        users = new ArrayList<>();
        hobbies = new HashSet<>();
        users.add(new User(1, "Anton", 10, new HashSet<>(List.of("hobby1", "hobby2"))));
        users.add(new User(2, "Antonio", 20, new HashSet<>(List.of("hobby2", "hobby3"))));
        users.add(new User(3, "Antonina", 30, new HashSet<>(List.of("hobby4", "hobby5"))));
        hobbies.addAll(List.of("hobby4", "hobby1"));
    }

    @Test
    public void testFindHobbyLovers() {
        Map<User, String> result = User.findHobbyLovers(users, hobbies);
        assertEquals(2, result.size());
    }

    @Test
    public void testFindHobbyLoversWithNullUserList() {
        Map<User, String> result = User.findHobbyLovers(null, hobbies);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindHobbyLoversWithNullHobbies() {
        Map<User, String> result = User.findHobbyLovers(users, null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindHobbyLoversWithEmptyUserList() {
        Map<User, String> result = User.findHobbyLovers(List.of(), hobbies);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFindHobbyLoversWithEmptyHobbiesSet() {
        Map<User, String> result = User.findHobbyLovers(users, Set.of());
        assertTrue(result.isEmpty());
    }
}
