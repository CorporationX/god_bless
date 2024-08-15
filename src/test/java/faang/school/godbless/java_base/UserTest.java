package faang.school.godbless.java_base;

import faang.school.godbless.java_base.exception.ErrorParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    private List<User> users;

    @BeforeEach
    public void setUp() {

        users = new ArrayList<>();
        users.add(new User("Petr", 30, "Google", "New York"));
        users.add(new User("Anna", 25, "Uber", "London"));
        users.add(new User("Elena", 30, "Amazon", "Amsterdam"));
        users.add(new User("Vadim", 25, "Uber", "London"));
        users.add(new User("Nikita", 40, "Amazon", "New York"));

    }

    @Test
    public void testGroupUsers() {

        Map<Integer, List<User>> groupedUsers = User.groupUsers(users);

        assertEquals(3, groupedUsers.size());

        assertEquals(2, groupedUsers.get(30).size());
        assertEquals(2, groupedUsers.get(25).size());
        assertEquals(1, groupedUsers.get(40).size());

        assertEquals("Petr", groupedUsers.get(30).get(0).getName());
        assertEquals("Elena", groupedUsers.get(30).get(1).getName());
        assertEquals("Anna", groupedUsers.get(25).get(0).getName());
        assertEquals("Vadim", groupedUsers.get(25).get(1).getName());
        assertEquals("Nikita", groupedUsers.get(40).get(0).getName());

    }

    @Test
    public void testValidUserCreation() {
        User user = new User("Alice", 30, "Google", "London");
        assertEquals("Alice", user.getName());
        assertEquals(30, user.getAge());
        assertEquals("Google", user.getWorkplace());
        assertEquals("London", user.getAddress());
    }

    @Test
    public void testInvalidName() {
        assertThrows(ErrorParameterException.class,() -> new User("", 30, "Google", "London"));
    }

    @Test
    public void testInvalidAge() {
        assertThrows(ErrorParameterException.class,() -> new User("Bob", 17, "Amazon", "New York"));
    }

    @Test
    public void testInvalidWorkplace() {
        assertThrows(ErrorParameterException.class,() -> new User("Charlie", 25, "Microsoft", "Amsterdam"));
    }

    @Test
    public void testInvalidAddress() {
        assertThrows(ErrorParameterException.class,() -> new User("David", 40, "Uber", "Paris"));
    }

}
