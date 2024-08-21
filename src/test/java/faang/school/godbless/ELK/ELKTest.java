package faang.school.godbless.ELK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ELKTest {
    private Main main;

    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;

    private Query query1;
    private Query query2;
    private Query query3;
    private Query query4;
    private Query query5;

    @BeforeEach
    void setUp() {
        main = new Main();
        user1 = new User(1, "Alice");
        user2 = new User(2, "Bob");
        user3 = new User(3, "Charlie");
        user4 = new User(4, "David");
        user5 = new User(5, "Eva");

        query1 = new Query(1, "Find coffee shops", new Timestamp(1627843200000L));
        query2 = new Query(2, "Weather today", new Timestamp(1627939600000L));
        query3 = new Query(3, "News update", new Timestamp(1628026000000L));
        query4 = new Query(4, "Check emails", new Timestamp(1628112400000L));
        query5 = new Query(5, "Plan weekend trip", new Timestamp(1628198800000L));

        main.addUser(user1);
        main.addUser(user2);
        main.addUser(user3);
        main.addUser(user4);
        main.addUser(user5);
    }

    @Test
    void testAddMultipleUsers() {
        assertEquals(5, main.getQueriesByUser().size());
    }

    @Test
    void testAddQueriesForMultipleUsers() {
        main.addUserQuery(user1, query1);
        main.addUserQuery(user1, query2);
        main.addUserQuery(user2, query3);
        main.addUserQuery(user3, query4);
        main.addUserQuery(user4, query5);


        assertEquals(2, main.getQueriesByUser().get(user1).size());
        assertEquals(1, main.getQueriesByUser().get(user2).size());
        assertEquals(1, main.getQueriesByUser().get(user3).size());
        assertEquals(1, main.getQueriesByUser().get(user4).size());
        assertEquals(0, main.getQueriesByUser().get(user5).size());

        assertTrue(main.getQueriesByUser().get(user1).contains(query1));
        assertTrue(main.getQueriesByUser().get(user1).contains(query2));
    }

    @Test
    void testRemoveUserWithQueries() {
        main.addUserQuery(user1, query1);
        main.addUserQuery(user2, query2);

        main.deleteUser(user1);
        assertFalse(main.getQueriesByUser().containsKey(user1));
        assertEquals(4, main.getQueriesByUser().size());

        main.deleteUser(user5);
        assertFalse(main.getQueriesByUser().containsKey(user5));
        assertEquals(3, main.getQueriesByUser().size());
    }

    @Test
    void testGetAllUsersAndTheirQueries() {
        main.getUsersInfo();
    }

    @Test
    void testGetUserInfo() {
        main.getUsersInfo(user5);
    }
}