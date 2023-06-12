package faang.school.goodbless;

import faang.school.godbless.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void groupUsersSuccessTest() {
        User user1 = new User("Ivan", 25, "Amazon", "London");
        User user2 = new User("Egor", 25, "Uber", "Amsterdam");
        User user3 = new User("Eva", 30, "Google", "New York");

        Map<Integer, List<User>> expectedMap = Map.of(
                25, List.of(user1, user2),
                30, List.of(user3)
        );

        assertEquals(expectedMap, User.groupUsers(List.of(user1, user2, user3)));
    }

    @Test
    void successUserTest() {
        User user = new User("Ivan", 20, "Amazon", "London");

        assertEquals(user, User.create("Ivan", 20, "Amazon", "London"));
    }

    @Test
    void wrongAddressUserTest() {
        assertThrows(IllegalArgumentException.class, () -> User.create("Ivan", 25, "Uber", "Address1"));
    }

    @Test
    void wrongWorkplaceUserTest() {
        assertThrows(IllegalArgumentException.class, () -> User.create("Ivan", 25, "Work", "London"));
    }

    @Test
    void wrongAgeUserTest() {
        assertThrows(IllegalArgumentException.class, () -> User.create("Ivan", 15, "Amazon", "London"));
    }

    @Test
    void wrongNameUserTest() {
        assertThrows(IllegalArgumentException.class, () -> User.create("", 20, "Uber", "London"));
    }
}