package faang.school.godbless.intro.collect_users;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CollectUsersTest {

    @Test
    void findHobbyLovers() {
        User user1 = new User(1, "Alice", 25,
                Set.of("Reading", "Painting"));
        User user2 = new User(2, "Bob", 30,
                Set.of("Tennis", "Soccer"));
        User user3 = new User(3, "Charlie", 27,
                Set.of("Swimming", "Cooking"));
        User user4 = new User(4, "David", 28,
                Set.of("Reading", "Cinema"));
        List<User> users = List.of(user1, user2, user3, user4);
        Set<String> activities = Set.of("Painting", "Cooking");

        Map<User, String> result = User.findHobbyLovers(users, activities);

        assertEquals(2, result.size());
        assertEquals("Painting", result.get(user1));
        assertEquals("Cooking", result.get(user3));
    }
}