package faang.school.godbless.group_users_by_age;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void test_nameNullThrow() {
        assertThrows(IllegalArgumentException.class, () -> new User(null, 21, "Google", "New York"));
    }

    @Test
    void test_nameEmptyThrow() {
        assertThrows(IllegalArgumentException.class, () -> new User("", 21, "Google", "New York"));
    }

    @Test
    void test_ageThrow() {
        assertThrows(IllegalArgumentException.class, () -> new User("George", 17, "Google", "New York"));
    }

    @Test
    void test_companyNameThrow() {
        assertThrows(IllegalArgumentException.class, () -> new User("George", 21, "OPS", "New York"));
    }

    @Test
    void test_userNameWithSpaces() {
        assertThrows(IllegalArgumentException.class, () -> new User("Someone else", 21, "OPS", "Yonge St. 5775"));
    }

    @Test
    void test() {
        User user1 = new User("George", 21, "Google", "New York");
        User user2 = new User("Ethan", 22, "Amazon", "London");
        User user3 = new User("Someoneelse", 21, "Amazon", "London");
        Map<Integer, List<User>> map = User.groupUsers(Arrays.asList(user2, user1, user3));

        System.out.println(map);
        System.out.println(map.get(21));
    }
}