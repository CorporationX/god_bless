package faang.school.godbless.task.hashmap.elk.query.index;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String... args) {
        Query query1 = new Query(1L, "Content 1", LocalDateTime.now().minusDays(1));
        Query query2 = new Query(2L, "Content 2", LocalDateTime.now().minusDays(2));
        Query query3 = new Query(3L, "Content 3", LocalDateTime.now().minusDays(4));
        Query query4 = new Query(4L, "Content 4", LocalDateTime.now().minusDays(23));
        Query query5 = new Query(5L, "Content 5", LocalDateTime.now().minusDays(5));
        Query query6 = new Query(6L, "Content 6", LocalDateTime.now().minusDays(7));
        Query query7 = new Query(7L, "Content 7", LocalDateTime.now().minusDays(16));
        Query query8 = new Query(8L, "Content 8", LocalDateTime.now().minusDays(17));
        Query query9 = new Query(9L, "Content 9", LocalDateTime.now().minusDays(12));
        Query query10 = new Query(10L, "Content 10", LocalDateTime.now().minusDays(10));

        List<Query> queryList1 = new ArrayList<>(List.of(query1, query2, query3));
        List<Query> queryList2 = new ArrayList<>(List.of(query4, query5, query6));
        List<Query> queryList3 = new ArrayList<>(List.of(query7, query8, query9, query10));

        User user1 = new User(1L, "User1");
        User user2 = new User(2L, "User2");
        User user3 = new User(3L, "User3");

        QueryManager queryManager = new QueryManager(new HashMap<>());

        queryManager.addNewUserWithQueryList(user1, queryList1);
        queryManager.printAllUsersWithQueries();

        queryManager.addNewUserWithQueryList(user1, queryList1);
        queryManager.addNewQueryToExistingUser(user1, query10);
        queryManager.printAllUsersWithQueries();

        queryManager.addNewUserWithQueryList(user1, queryList1);
        queryManager.addNewUserWithQueryList(user2, queryList2);
        queryManager.deleteUser(user1);
        queryManager.printAllUsersWithQueries();

        queryManager.addNewUserWithQueryList(user1, queryList1);
        queryManager.addNewUserWithQueryList(user2, queryList2);
        queryManager.addNewUserWithQueryList(user3, queryList3);
        queryManager.printAllQueriesByUser(user1);

        queryManager.printAllUsersWithQueries();
    }
}
