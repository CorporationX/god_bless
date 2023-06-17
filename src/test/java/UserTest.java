import faang.school.godbless.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private static final List<String> JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> ADDRESSES = List.of("London", "New York", "Amsterdam");
    private static final Random RANDOM = new Random();
    private static List<User> userList;

    @BeforeAll
    static void initValidUserList() {
        userList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            userList.add(new User(
                    "User-" + i,
                    RANDOM.nextInt(18, 100),
                    JOBS.get(RANDOM.nextInt(0,3)),
                    ADDRESSES.get(RANDOM.nextInt(0, 3))
            ));
        }
    }

    @Test
    void groupUsersByAgeTest() {
        for (List<User> users : User.groupUsers(userList).values()) {
            assertTrue(users.stream()
                    .allMatch(user -> user.getAge() == users.get(0).getAge())
            );
        }
    }

    @Test
    void groupList_shouldReturnEmptyMapTest() {
        assertTrue(User.groupUsers(Collections.emptyList()).isEmpty());
    }

    @Test
    void userConstructor_shouldThrowExceptionWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 30, "Uber","London"));
        try {
            new User("", 30, "Uber","London");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Name could not be blank");
        }
    }

    @Test
    void userConstructor_shouldThrowExceptionWithInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> new User("Tom", 13, "Uber","London"));
        try {
            new User("Tom", 13, "Uber","London");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Age could not be less than 18");
        }
    }

    @Test
    void userConstructor_shouldThrowExceptionWithIncorrectJob() {
        assertThrows(IllegalArgumentException.class, () -> new User("Tom", 30, "Avito","London"));
        try {
            new User("Tom", 30, "Avito","London");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Job name is incorrect");
        }
    }

    @Test
    void userConstructor_shouldThrowExceptionWithIncorrectAddress() {
        assertThrows(IllegalArgumentException.class, () -> new User("Tom", 30, "Uber","Moscow"));
        try {
            new User("Tom", 30, "Uber","Moscow");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Address is incorrect");
        }
    }

    @Test
    void userConstructor_shouldReturnNewUser() {
        User actual = new User("Tom", 30, "Google", "London");
        assertEquals(actual, new User("Tom", 30, "Google", "London"));
    }
}