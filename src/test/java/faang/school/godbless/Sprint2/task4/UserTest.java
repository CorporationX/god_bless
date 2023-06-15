package faang.school.godbless.Sprint2.task4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void testFindHobbyLovers() {
        List<User> users = Arrays.asList(
                new User(1, 35, "Rasul", Set.of("Sport", "Selfedu")),
                new User(2, 25, "Jon", Set.of("Reading", "Music")),
                new User(3, 30, "Mike", Set.of("Smoking", "Crimes")));

        Set<String> activitiesSet = Set.of("Photo", "Sport", "Drive", "Music", "Dancing");

        Map<User, String> map = User.findHobbyLovers(users, activitiesSet);

        assertEquals(2, map.size());
        assertEquals("Sport", map.get(users.get(0)));
        assertEquals("Music", map.get(users.get(1)));
        assertEquals(null, map.get(users.get(2)));
    }
}