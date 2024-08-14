package faang.school.godbless.BJS2_19773;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class QueryServiceTest {
    private QueryService queryService;

    @BeforeEach
    void setUp() {
        List<Query> queries = new ArrayList<>();
        queries.add(new Query(1, "Some Content", LocalDateTime.now()));
        queries.add(new Query(2, "Some Content2", LocalDateTime.now()));
        queries.add(new Query(3, "Some Content3", LocalDateTime.now()));
        Map<User, List<Query>> userQueries = new HashMap<>();
        userQueries.put(new User(1, "Michael"), queries);
        queryService = new QueryService(userQueries);
        queryService.printQueries();
    }

    @Test
    void testAddingNewUserAndQueries() {

        User user = new User(2, "Kyle");
        List<Query> queries = new ArrayList<>();
        queries.add(new Query(4, "Added Content", LocalDateTime.now()));
        queries.add(new Query(5, "Added Content2", LocalDateTime.now()));
        queryService.addUser(user, queries);
        assertEquals(2, queryService.getQueries().size());

        queryService.addUser(user, List.of(new Query(6, "Added Content", LocalDateTime.now())));
        assertEquals(3, queryService.getQueries().get(user).size());
    }

    @Test
    void testAddingQuery() {
        User user = new User(1, "Michael");
        queryService.addQuery(user, new Query(10, "Added Content", LocalDateTime.now()));
        assertEquals(4, queryService.getQueries().get(user).size());
    }

    @Test
    void testRemoveUser() {
        queryService.removeUser(new User(1, "Michael"));
        assertEquals(0, queryService.getQueries().size());
    }

    @Test
    void testAddingQueryToAbsentUser() {
        assertThrows(IllegalArgumentException.class, () -> queryService.addQuery(new User(10, "Elrik"), new Query(1, "Added Content", LocalDateTime.now())));
    }


}
