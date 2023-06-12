package faang.school.goodbless;

import faang.school.godbless.User;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void groupUsersSuccessTest() {
        User user1 = new User("Ivan", 25, "Work1", "Address1");
        User user2 = new User("Egor", 25, "Work1", "Address2");
        User user3 = new User("Eva", 30, "Work1", "Address3");

        Map<Integer, List<User>> expectedMap = Map.of(
                25, List.of(user1, user2),
                30, List.of(user3)
        );

        assertEquals(expectedMap, User.groupUsers(List.of(user1, user2, user3)));
    }
}