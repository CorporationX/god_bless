package faang.school.godbless.task.elk.query.index;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QueryManagerTest {
    private Query query1 = new Query(1, "Content 1", LocalDateTime.now().minusDays(1));
    private Query query2 = new Query(2, "Content 2", LocalDateTime.now().minusDays(2));
    private Query query3 = new Query(3, "Content 3", LocalDateTime.now().minusDays(4));
    private Query query4 = new Query(4, "Content 4", LocalDateTime.now().minusDays(23));
    private Query query5 = new Query(5, "Content 5", LocalDateTime.now().minusDays(5));
    private Query query6 = new Query(6, "Content 6", LocalDateTime.now().minusDays(7));
    private Query query7 = new Query(7, "Content 7", LocalDateTime.now().minusDays(16));
    private Query query8 = new Query(8, "Content 8", LocalDateTime.now().minusDays(17));
    private Query query9 = new Query(9, "Content 9", LocalDateTime.now().minusDays(12));
    private Query query10 = new Query(10, "Content 10", LocalDateTime.now().minusDays(10));

    private List<Query> queryList1 = new ArrayList<>(List.of(query1, query2, query3));
    private List<Query> queryList2 = new ArrayList<>(List.of(query4, query5, query6));
    private List<Query> queryList3 = new ArrayList<>(List.of(query7, query8, query9, query10));

    private User user1 = new User(1, "User1");
    private User user2 = new User(2, "User2");
    private User user3 = new User(3, "User3");

    private QueryManager queryManager;

    @BeforeEach
    void setUp() {
        queryManager = new QueryManager(new HashMap<>());
    }

    @Test
    @DisplayName("Add new user with query list")
    void testAddNewUserWithQueryList() {
        queryManager.addNewUserWithQueryList(user1, queryList1);
        queryManager.printAllUsersWithQueries();
    }

    @Test
    @DisplayName("Add new query to existing user")
    void testAddNewQueryToExistingUser() {
        queryManager.addNewUserWithQueryList(user1, queryList1);
        queryManager.addNewQueryToExistingUser(user1, query10);
        queryManager.printAllUsersWithQueries();
    }

    @Test
    @DisplayName("Delete user")
    void testDeleteUser() {
        queryManager.addNewUserWithQueryList(user1, queryList1);
        queryManager.addNewUserWithQueryList(user2, queryList2);
        queryManager.deleteUser(user1);
        queryManager.printAllUsersWithQueries();
    }

    @Test
    @DisplayName("Print all queries by user")
    void testPrintAllQueriesByUser() {
        queryManager.addNewUserWithQueryList(user1, queryList1);
        queryManager.addNewUserWithQueryList(user2, queryList2);
        queryManager.addNewUserWithQueryList(user3, queryList3);
        queryManager.printAllQueriesByUser(user1);
    }

    @Test
    @DisplayName("Print all users with queries when have empty map")
    void testPrintAllUsersWithQueriesWhenEmptyMap() {
        queryManager.printAllUsersWithQueries();
    }
}
