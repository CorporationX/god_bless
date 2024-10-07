package school.faang.elk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.*;

class ElkQueryTest {

    private ElkQuery elkQuery;
    private User user1;
    private User user2;
    private Query query1;
    private Query query2;
    private Query query3;

    @BeforeEach
    public void setUp() {
        elkQuery = new ElkQuery();

        user1 = new User("User 1");
        user2 = new User("User 2");

        query1 = new Query(1, "Query 1", now());
        query2 = new Query(2, "Query 2", now().minusDays(2));
        query3 = new Query(3, "Query 3", now().minusDays(3));

        List<Query> user1Queries = new ArrayList<>();
        user1Queries.add(query1);
        user1Queries.add(query2);

        List<Query> user2Queries = new ArrayList<>();
        user2Queries.add(query3);

        elkQuery.addUser(user1, user1Queries);
        elkQuery.addUser(user2, user2Queries);
    }

    @Test
    void addUserTest() {
        int initializeUserCount = elkQuery.getUsersQueries().keySet().size();
        User user3 = new User("User 3");
        List<Query> user3Queries = new ArrayList<>();
        user3Queries.add(new Query(4, "Query 4", now().minusDays(4)));

        elkQuery.addUser(user3, user3Queries);

        assertEquals(initializeUserCount + 1, elkQuery.getUsersQueries().keySet().size());
    }

    @Test
    void addQueryForUserTest() {
        int initializeQueryCount = elkQuery.getUsersQueries().get(user1).size();
        Query newQuery = new Query(5, "Query 5", now().minusDays(5));
        elkQuery.addQueryForUser(user1, newQuery);

        List<Query> user1Queries = elkQuery.getUsersQueries().get(user1);

        assertEquals(initializeQueryCount + 1, user1Queries.size());
    }

    @Test
    void addQueryForNewUserTest() {
        User newUser = new User("User 3");
        Query newQuery = new Query(5, "Query 5", now().minusDays(5));
        elkQuery.addQueryForUser(newUser, newQuery);

        List<Query> newUserQueries = elkQuery.getUsersQueries().get(newUser);

        assertEquals(1, newUserQueries.size());
    }

    @Test
    void deleteUserTest() {
        elkQuery.deleteUser(user1);
        assertNull(elkQuery.getUsersQueries().get(user1));
    }

    @Test
    void printAllUsersWithQueriesTest() {
        elkQuery.printAllUsersWithQueries();
    }

    @Test
    void printAllUsersWithQueriesSortedByTimestampTest() {
        elkQuery.printAllUsersWithQueriesSortedByTimestamp();
    }
}
