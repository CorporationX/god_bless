package faang.school.godbless.bjs2_19737;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MainTest {

    private Main main;
    private User user1;
    private User user2;
    private Query query1;
    private Query query2;
    private Query query3;
    private LocalDateTime time;

    @BeforeEach
    public void setUp() {
        time = now();
        main = new Main();
        user1 = new User(1, "John");
        user2 = new User(2, "Ivan");
        query1 = new Query(1, "Query 1");
        query2 = new Query(2, "Query 2");
        query3 = new Query(3, "Query 3");
    }

    @Test
    void addUserWithQueries() {
        List<Query> queries = new ArrayList<>();
        query1 = new Query(1, "Query 1", time);
        query2 = new Query(2, "Query 2", time.plusMinutes(1));
        query3 = new Query(3, "Query 3", time.minusMinutes(1));

        queries.add(query1);
        queries.add(query2);
        queries.add(query3);

        main.addUserWithQueries(user1, queries);

        var userQueries = main.getUserQueries().get(user1);
        assertEquals(3, userQueries.size());
        assertEquals(2, userQueries.get(0).getId());
        assertEquals(1, userQueries.get(1).getId());
        assertEquals(3, userQueries.get(2).getId());
    }

    @Test
    void addQueryToUser() {
        List<Query> queries = new ArrayList<>();
        query1 = new Query(1, "Query 1", time);
        query2 = new Query(2, "Query 2", time.plusMinutes(1));
        query3 = new Query(3, "Query 3", time.minusMinutes(1));

        queries.add(query1);
        queries.add(query2);
        queries.add(query3);

        main.addUserWithQueries(user1, queries);

        var userQueries0 = main.getUserQueries().get(user1);
        assertEquals(3, userQueries0.size());
        assertEquals(2, userQueries0.get(0).getId());
        assertEquals(1, userQueries0.get(1).getId());
        assertEquals(3, userQueries0.get(2).getId());

        // add to tail
        var query4 = new Query(4, "Query 4", time.minusMinutes(2));
        main.addQueryToUser(query4, user1);

        var userQueries = main.getUserQueries().get(user1);
        assertEquals(4, userQueries.size());
        assertEquals(2, userQueries.get(0).getId());
        assertEquals(1, userQueries.get(1).getId());
        assertEquals(3, userQueries.get(2).getId());
        assertEquals(4, userQueries.get(3).getId());

        // add to head
        var query5 = new Query(5, "Query 5", time.plusMinutes(2));
        main.addQueryToUser(query5, user1);
        var userQueries2 = main.getUserQueries().get(user1);
        assertEquals(5, userQueries2.size());
        assertEquals(5, userQueries2.get(0).getId());
        assertEquals(2, userQueries2.get(1).getId());
        assertEquals(1, userQueries2.get(2).getId());
        assertEquals(3, userQueries2.get(3).getId());
        assertEquals(4, userQueries2.get(4).getId());

        // add to middle
        var query6 = new Query(6, "Query 6", time.plusMinutes(1).minusSeconds(30));
        main.addQueryToUser(query6, user1);
        var userQueries3 = main.getUserQueries().get(user1);
        assertEquals(6, userQueries3.size());
        assertEquals(5, userQueries3.get(0).getId()); // plusMinutes(2)
        assertEquals(2, userQueries3.get(1).getId()); // plusMinutes(1)
        assertEquals(6, userQueries3.get(2).getId()); // plusMinutes(1).minusSeconds(30)
        assertEquals(1, userQueries3.get(3).getId()); // 0
        assertEquals(3, userQueries3.get(4).getId()); // minusMinutes(1)
        assertEquals(4, userQueries3.get(5).getId()); // minusMinutes(2)
    }

    @Test
    void removeUser() {
        List<Query> queries = new ArrayList<>();
        queries.add(query1);
        main.addUserWithQueries(user1, queries);

        main.removeUser(user1);

        assertFalse(main.getUserQueries().containsKey(user1));
    }
}