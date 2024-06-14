package faang.school.godbless.task1;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private List<User> users;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        users.add(new User("Alice", 25, "Uber", "London"));
        users.add(new User("Bob", 30, "Uber", "London"));
        users.add(new User("Charlie", 25, "Uber", "London"));
        users.add(new User("David", 30, "Uber", "London"));
        users.add(new User("Eve", 35, "Uber", "London"));
    }

    @Test
    @DisplayName("Тест сортировки пользователей")
    void testGroupUsers() {
        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        assertEquals(3, groupedUsers.size());

        assertEquals(2, groupedUsers.get(25).size());
        assertEquals("Alice", groupedUsers.get(25).get(0).getName());
        assertEquals("Charlie", groupedUsers.get(25).get(1).getName());

        assertEquals(2, groupedUsers.get(30).size());
        assertEquals("Bob", groupedUsers.get(30).get(0).getName());
        assertEquals("David", groupedUsers.get(30).get(1).getName());

        assertEquals(1, groupedUsers.get(35).size());
        assertEquals("Eve", groupedUsers.get(35).get(0).getName());
    }

    @Test
    @DisplayName("Тест конструктора с некорректными условиями")
    void testConstructor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            User user = new User("Vlad", 18, "Student", "Minsk");
        });
        String expectedMessage = "Invalid workplace";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

}