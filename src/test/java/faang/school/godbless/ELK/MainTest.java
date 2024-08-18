package faang.school.godbless.ELK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main main;
    private User user1;
    private User user2;
    private Query query1;
    private Query query2;

    @BeforeEach
    public void setUp() {
        main = new Main();

        user1 = new User(1, "Alice");
        user2 = new User(2, "Bob");

        query1 = new Query(1, "search something", new Timestamp(System.currentTimeMillis() - 86400000));
        query2 = new Query(2, "another search", new Timestamp(System.currentTimeMillis()));
    }

    @Test
    public void testAddUser() {
        main.addUser(user1);
        assertTrue(main.getAllUsers().contains(user1));
    }

    @Test
    public void testAddUserQuery() {
        main.addUser(user1);
        main.addUserQuery(user1, query1);
        List<Query> queries = main.getQueriesByUser().get(user1);
        assertEquals(1, queries.size());
        assertEquals(query1, queries.get(0));
    }

    @Test
    public void testDeleteUser() {
        main.addUser(user1);
        main.deleteUser(user1);
        assertFalse(main.getAllUsers().contains(user1));
    }

    @Test
    public void testGetAllUsers() {
        main.addUser(user1);
        main.addUser(user2);
        List<User> users = main.getAllUsers();
        assertEquals(2, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
    }

    @Test
    public void testGetUsersInfo_SpecificUser() {
        main.addUser(user1);
        main.addUserQuery(user1, query2);
        main.addUserQuery(user1, query1);

        main.getUsersInfo(user1);
        List<Query> queries = main.getQueriesByUser().get(user1);
        assertEquals(query1, queries.get(0));
        assertEquals(query2, queries.get(1));
    }
}