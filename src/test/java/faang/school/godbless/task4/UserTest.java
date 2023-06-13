package faang.school.godbless.task4;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testFindHobbyLovers() {
        User user1 = new User(1, "Иван", 22, Set.of("футбол", "воркаут", "танцы"));
        User user2 = new User(1, "Петя", 22, Set.of("баскетбол", "теннис"));
        User user3 = new User(1, "Виктор", 22, Set.of("легкая атлетика", "плавание"));

        List<User> users = List.of(user1, user2, user3);

        Set<String> activities = Set.of("футбол", "танцы", "теннис", "плавание");

        Map<User, String> hobbyLovers = user1.findHobbyLovers(users, activities);


        assertEquals(hobbyLovers.get(user2), "теннис");
        assertEquals(hobbyLovers.get(user3), "плавание");
    }
}