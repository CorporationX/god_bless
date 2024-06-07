package faang.school.godbless.task_005;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    int count;
    List<User> users;
    Set<String> setHobbies;


    @BeforeEach
    void setUp() {
        int count = 0;
        users = new ArrayList<>();
        users.add(new User(++count, "Serg", 35, new HashSet<>(Set.of("Warcraft3", "Village"))));
        setHobbies = new HashSet<>(Set.of("Chess", "Paintball", "Video Games", "Football", "Dance", "Sleep", "Eat", "Play"));

    }

    @Test
    void testInitUser() {
        // Arrange
        int id = 1;
        String name = "Serg";
        int age = 35;
        Set<String> hobbies = new HashSet<>(Set.of("Warcraft3", "Village"));
        // Act
        User testUser = new User(id, name, age, hobbies);

        // Assert
        assertEquals(id, testUser.id(), "the id parameter must match");
        assertEquals(name, testUser.name(), "the name parameter must match");
        assertEquals(age, testUser.age(), "the age parameter must match");
        Assertions.assertArrayEquals(hobbies.toArray(), testUser.hobbies().toArray(), "the hobbies parameter must match");
    }

    @Test
    void testFindHobbyLovers_default() {
        // Arrange
        User secondUser = new User(++count, "Kate", 34, new HashSet<>(Set.of("Chess")));
        users.add(secondUser);

        // Act
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, setHobbies);

        // Assert
        assertEquals(1, hobbyLovers.size(), "the number of users in the set must be 1");
        assertTrue(hobbyLovers.containsKey(secondUser), "there must be one user in the set: Kate");
    }

    @Test
    void testFindHobbyLovers_singleAddition() {
        // Arrange
        User thirdUser = new User(++count, "Mary", 1, new HashSet<>(Set.of("Sleep", "Eat", "Play")));
        users.add(thirdUser);

        // Act
        Map<User, String> hobbyLovers = User.findHobbyLovers(users, setHobbies);

        // Assert
        assertEquals(1, hobbyLovers.size(), "the number of users in the set must be 1");
    }
}
