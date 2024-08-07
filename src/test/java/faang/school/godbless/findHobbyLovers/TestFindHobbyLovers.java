package faang.school.godbless.findHobbyLovers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFindHobbyLovers {

    @Test
    @DisplayName("Collecting users by activities by Loops and Ifs")
    public void testFindHobbyLoversByLoopsAndIfs() {
        List<User> usersList = List.of(
                new User(1, "Vika", 19, new HashSet<>(Arrays.asList("psy", "it", "art"))),
                new User(2, "Dima", 20, new HashSet<>(Arrays.asList("it", "cars", "moto"))),
                new User(3, "Sasha", 21, new HashSet<>(Arrays.asList("art", "cars", "moto"))),
                new User(4, "Sergey", 22, new HashSet<>(Arrays.asList("cars", "moto")))
        );

        Set<String> activitiesSet = Set.of("psy", "it", "art");

        Map<User, String> usersMap;
        usersMap = User.findHobbyLoversByLoopsAndIfs(usersList, activitiesSet);

        assertAll(
                () -> assertEquals(3, usersMap.size()),
                () -> assertTrue(usersMap.containsKey(
                        new User(1, "Vika", 19, new HashSet<>(Arrays.asList("psy", "it", "art")))
                )),
                () -> assertTrue(usersMap.containsKey(
                        new User(2, "Dima", 20, new HashSet<>(Arrays.asList("it", "cars", "moto")))
                )),
                () -> assertTrue(usersMap.containsKey(
                        new User(3, "Sasha", 21, new HashSet<>(Arrays.asList("art", "cars", "moto")))
                )),
                () -> assertFalse(usersMap.containsKey(
                        new User(4, "Sergey", 22, new HashSet<>(Arrays.asList("cars", "moto")))
                ))
        );
    }

    @Test
    @DisplayName("Collecting users by activities by Stream API")
    public void testFindHobbyLoversByStreams() {
        List<User> usersList = List.of(
                new User(1, "Vika", 19, new HashSet<>(Arrays.asList("psy", "it", "art"))),
                new User(2, "Dima", 20, new HashSet<>(Arrays.asList("it", "cars", "moto"))),
                new User(3, "Sasha", 21, new HashSet<>(Arrays.asList("art", "cars", "moto"))),
                new User(4, "Sergey", 22, new HashSet<>(Arrays.asList("cars", "moto")))
        );

        Set<String> activitiesSet = Set.of("psy", "it", "art");

        Map<User, String> usersMap;
        usersMap = User.findHobbyLoversByStream(usersList, activitiesSet);

        assertAll(
                () -> assertEquals(3, usersMap.size()),
                () -> assertTrue(usersMap.containsKey(
                        new User(1, "Vika", 19, new HashSet<>(Arrays.asList("psy", "it", "art")))
                )),
                () -> assertTrue(usersMap.containsKey(
                        new User(2, "Dima", 20, new HashSet<>(Arrays.asList("it", "cars", "moto")))
                )),
                () -> assertTrue(usersMap.containsKey(
                        new User(3, "Sasha", 21, new HashSet<>(Arrays.asList("art", "cars", "moto")))
                )),
                () -> assertFalse(usersMap.containsKey(
                        new User(4, "Sergey", 22, new HashSet<>(Arrays.asList("cars", "moto")))
                ))
        );
    }

}
