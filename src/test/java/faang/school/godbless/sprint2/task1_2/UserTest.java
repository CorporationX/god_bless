package faang.school.godbless.sprint2.task1_2;

import faang.school.godbless.sprint2.task1_2.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private static final List<String> JOBS = List.of("Google", "Uber", "Amazon");
    private static final List<String> ADDRESSES = List.of("London", "New York", "Amsterdam");
    private static final Random RANDOM = new Random();
    private static List<User> userList;

    @BeforeEach
    private void setUpUserList() {
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
        assertThrows(
                IllegalArgumentException.class, () -> new User("", 30, "Uber","London"),
                "Name could not be blank");
    }

    @Test
    void userConstructor_shouldThrowExceptionWithInvalidAge() {
        assertThrows(IllegalArgumentException.class, () -> new User("Tom", 13, "Uber","London"),
                "Age could not be less than 18");
    }

    @Test
    void userConstructor_shouldThrowExceptionWithIncorrectJob() {
        assertThrows(IllegalArgumentException.class, () -> new User("Tom", 30, "Avito","London"),
                "Job name is incorrect");
    }

    @Test
    void userConstructor_shouldThrowExceptionWithIncorrectAddress() {
        assertThrows(IllegalArgumentException.class, () -> new User("Tom", 30, "Uber","Moscow"),
                "Address is incorrect");
    }

    @Test
    void userConstructor_shouldReturnNewUser() {
        User actual = new User("Tom", 30, "Google", "London");
        assertEquals(actual, new User("Tom", 30, "Google", "London"));
    }
}
