package faang.school.godbless.BJS2_20020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private User userOne;
    private User userTwo;
    private Query queryTwo;
    private Map<User, List<Query>> userQueries;

    @BeforeEach
    public void setUp() {
        main = new Main();
        userOne = new User(1, "Петя");
        userTwo = new User(2, "Саша");
        Query queryOne = new Query(1, "Привет", Timestamp.valueOf("2023-08-03 14:30:12"));
        queryTwo = new Query(2, "Здарово", Timestamp.valueOf("2023-08-03 14:31:45"));
        userQueries = main.getUserQueries();
        List<Query> queries = new ArrayList<>();
        queries.add(queryOne);
        userQueries.put(userOne, queries);
    }

    @Test
    void testAddUser() {
        main.addUser(userTwo);
        Map<User, List<Query>> userQueries = main.getUserQueries();
        assertTrue(userQueries.containsKey(userTwo));
        assertEquals(0, userQueries.get(userTwo).size());
    }

    @Test
    void testAddQuery() {
        main.addUser(userTwo);
        main.addQuery(userTwo, queryTwo);
        Map<User, List<Query>> userQueries = main.getUserQueries();
        assertTrue(userQueries.containsKey(userTwo));
        assertEquals(1, userQueries.get(userTwo).size());
        assertEquals(queryTwo, userQueries.get(userTwo).get(0));
    }

    @Test
    void testRemoveUserWithQuery() {
        main.removeUserWithQuery(userOne);
        assertNull(userQueries.get(userOne));
    }
}