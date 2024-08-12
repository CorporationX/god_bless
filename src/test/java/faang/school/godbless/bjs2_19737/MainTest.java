package faang.school.godbless.bjs2_19737;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    private MainList main;
    private User user1;
    private User user2;
    private Query query1;
    private Query query2;
    private Query query3;

    @BeforeEach
    public void setUp() {
        main = new MainList();
        user1 = new User(1, "John");
        user2 = new User(2, "Ivan");
        query1 = new Query(1, "Query 1");
        query2 = new Query(2, "Query 2");
        query3 = new Query(3, "Query 3");
    }

    @Test
    void addUserWithQueries() {
        List<Query> queries = new ArrayList<>();
        queries.add(query1);
        queries.add(query2);

        main.addUserWithQueries(user1, queries);

        assertEquals(2, main.getUserQueries().get(user1).size());
    }

    @Test
    void addQueryToUser() {
        List<Query> queries = new ArrayList<>();
        queries.add(query1);
        main.addUserWithQueries(user1, queries);

        main.addQueryToUser(query2, user1);

        assertEquals(2, main.getUserQueries().get(user1).size());
        assertTrue(main.getUserQueries().get(user1).contains(query2));
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