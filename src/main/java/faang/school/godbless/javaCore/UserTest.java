package faang.school.godbless.javaCore;


import lombok.val;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class UserTest {

    @Test
    void findHobbyLoversTest() {
        Set<String> activitiesUser1 = new HashSet<>(Set.of("Chess", "Sport", "Swimming"));
        Set<String> activitiesUser2 = new HashSet<>(Set.of("Sport", "Swimming"));
        Set<String> activitiesUser3 = new HashSet<>(Set.of("Chess", "Swimming"));

        val user1 = new User(0, "name1", 19, activitiesUser1);
        val user2 = new User(1, "name2", 20, activitiesUser2);
        val user3 = new User(2, "name3", 21, activitiesUser3);
        List<User> userList = new ArrayList<>(List.of(user1, user2, user3));

        Set<String> currentHobbySet = new HashSet<>(Set.of("Chess", "Fishing"));
        Map<User, String> expectedResult = new HashMap<>();
        expectedResult.put(user1, "Chess");
        expectedResult.put(user3, "Chess");

        assertEquals(expectedResult, User.findHobbyLovers(userList, currentHobbySet));
    }
}