package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {

    @Test
    void findHobbyLovers() {
        User user1 = new User(1, "John", 25, new HashSet<>(Arrays.asList("Running", "Swimming")));
        User user2 = new User(2, "Alice", 30, new HashSet<>(Arrays.asList("Cycling", "Reading")));
        User user3 = new User(3, "Bob", 20, new HashSet<>(Arrays.asList("Reading", "Cooking")));
        User user4 = new User(4, "Sarah", 28, new HashSet<>(Arrays.asList("Swimming", "Painting")));

        List<User> userList = Arrays.asList(user1, user2, user3, user4);

        Set<String> hobbies = new HashSet<>(Arrays.asList("Reading", "Running"));

        Map<User, String> testMap = user1.findHobbyLovers(userList, hobbies);
        System.out.println(testMap);
        assertEquals(testMap.size(), 3);
    }
}