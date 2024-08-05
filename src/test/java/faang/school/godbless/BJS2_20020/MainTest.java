package faang.school.godbless.BJS2_20020;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest extends Main {
    private Main main;
    private User user1;
    private User user2;
    private Query query2;
    private Map<User, List<Query>> userQueries;

    @BeforeEach
    public void setUp() {
        main = new Main();
        user1 = new User(1, "Петя");
        user2 = new User(2, "Саша");
        Query query1 = new Query(1, "Привет", Timestamp.valueOf("2023-08-03 14:30:12"));
        query2 = new Query(2, "Здарово", Timestamp.valueOf("2023-08-03 14:31:45"));
        userQueries = main.getUserQueries();
        List<Query> queries = new ArrayList<>();
        queries.add(query1);
        userQueries.put(user1, queries);
    }

    @Test
    void testAddUser() {
        main.addUser(user2);
        Map<User, List<Query>> userQueries = main.getUserQueries();
        assertTrue(userQueries.containsKey(user2));
        assertEquals(0, userQueries.get(user2).size());
    }

    @Test
    void testAddQuery() {
        main.addUser(user2);
        main.addQuery(user2, query2);
        Map<User, List<Query>> userQueries = main.getUserQueries();
        assertTrue(userQueries.containsKey(user2));
        assertEquals(1, userQueries.get(user2).size());
        assertEquals(query2, userQueries.get(user2).get(0));
    }

    @Test
    void testRemoveUserWithQuery() {
        main.removeUserWithQuery(user1);
        assertNull(userQueries.get(user1));
    }
}