package faang.school.godbless.index.request.elk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @BeforeEach
    void clearMap() {
        Main.userRequestMap.clear();
    }

    @Test
    void testAddUser() {
        User bob = new User(1, "Bob");
        List<Query> bobsQueries = new ArrayList<>();
        bobsQueries.add(new Query(1, "Today plain fel",
                LocalDateTime.of(LocalDate.of(2024, 8, 9),
                        LocalTime.of(12, 15, 35))));
        bobsQueries.add(new Query(2, "How to override toString() in java",
                LocalDateTime.of(LocalDate.of(2024, 8, 2),
                        LocalTime.of(10, 15, 35))));
        bobsQueries.add(new Query(3, "Weather in New York in next week",
                LocalDateTime.of(LocalDate.of(2024, 8, 5),
                        LocalTime.of(10, 55, 35))));
        Main.addUser(bob, bobsQueries);

        Assertions.assertEquals(1, Main.userRequestMap.size());
        Assertions.assertEquals(bobsQueries, Main.userRequestMap.get(bob));
    }

    @Test
    void testAddRequest() {
        User mary = new User(2, "Mary");
        Query query = new Query(4, "The cat has a hot nose",
                LocalDateTime.of(LocalDate.of(2024, 7, 5),
                        LocalTime.of(10, 15, 35)));
        Main.addRequest(mary, query);

        Assertions.assertEquals(1, Main.userRequestMap.size());
        Assertions.assertEquals(1, Main.userRequestMap.get(mary).size());
        Assertions.assertEquals(query, Main.userRequestMap.get(mary).get(0));
    }

    @Test
    void testDeleteUser() {
        User bob = new User(1, "Bob");
        List<Query> bobsQueries = new ArrayList<>();
        bobsQueries.add(new Query(1, "Today plain fel",
                LocalDateTime.of(LocalDate.of(2024, 8, 9),
                        LocalTime.of(12, 15, 35))));
        Main.addUser(bob, bobsQueries);

        User mary = new User(2, "Mary");
        Query query = new Query(4, "The cat has a hot nose",
                LocalDateTime.of(LocalDate.of(2024, 7, 5),
                        LocalTime.of(10, 15, 35)));
        Main.addRequest(mary, query);
        Assertions.assertEquals(2, Main.userRequestMap.size());
        Assertions.assertTrue(Main.userRequestMap.keySet().containsAll(List.of(bob, mary)));

        Main.deleteUser(bob);
        Assertions.assertEquals(1, Main.userRequestMap.size());
        Assertions.assertFalse(Main.userRequestMap.containsKey(bob));
    }
}
