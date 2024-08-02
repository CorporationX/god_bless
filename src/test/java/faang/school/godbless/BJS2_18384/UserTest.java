package faang.school.godbless.BJS2_18384;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void groupUsers() {
        User user1 = new User("Robert", 18, "FAANG School", "secret");
        User user2 = new User("Inna", 25, "FAANG School", "secret");
        User user3 = new User("Mihail", 30, "FAANG School", "secret");
        User user4 = new User("Blad", 18, "FAANG School", "secret");
        User user5 = new User("Kana", 25, "FAANG School", "secret");
        User user6 = new User("Vitalik", 18, "FAANG School", "secret");
        List<User> users = List.of(user1, user2, user3, user4, user5, user6);

        Map<Integer, List<User>> correctAnswer = Map.of(
                18, List.of(user1, user4, user6),
                25, List.of(user2, user5),
                30, List.of(user3)
        );

        Map<Integer, List<User>> result = User.groupUsers(users);

        assertEquals(correctAnswer, result);
    }

    @Test
    void groupUsers_EmptyList() {
        List<User> users = new ArrayList<>();
        Map<Integer, List<User>> correctAnswer = new HashMap<>();

        Map<Integer, List<User>> result = User.groupUsers(users);

        assertEquals(correctAnswer, result);
    }
}