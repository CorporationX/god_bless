package faang.school.godbless.findHobbyLovers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestFindHobbyLovers {

    @Test
    @DisplayName("Collecting users by activities")
    public void testFindHobbyLovers() {
        List<User> usersList = new ArrayList<>();

        User user1 = new User(1, "Vika", 19, new HashSet<>(Arrays.asList("psy", "it", "art")));
        usersList.add(user1);

        User user2 = new User(2, "Dima", 20, new HashSet<>(Arrays.asList("it", "cars", "moto")));
        usersList.add(user2);

        User user3 = new User(3, "Sasha", 21, new HashSet<>(Arrays.asList("art", "cars", "moto")));
        usersList.add(user3);

        User user4 = new User(4, "Sergey", 22, new HashSet<>(Arrays.asList("cars", "moto")));
        usersList.add(user4);

        Set<String> activitiesSet = new HashSet<>();
        activitiesSet.add("psy");
        activitiesSet.add("it");
        activitiesSet.add("art");

        Map<User, String> usersMap;
        usersMap = User.findHobbyLovers(usersList, activitiesSet);

        assertAll(
                () -> assertNotNull(usersMap),
                () -> assertEquals(3, usersMap.size()),
                () -> assertEquals(true, usersMap.containsKey(user1)),
                () -> assertEquals(true, usersMap.containsKey(user2)),
                () -> assertEquals(true, usersMap.containsKey(user3)),
                () -> assertEquals(false, usersMap.containsKey(user4))
        );
    }
}
